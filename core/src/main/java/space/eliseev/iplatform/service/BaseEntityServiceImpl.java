package space.eliseev.iplatform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.repackaged.org.apache.commons.lang3.math.NumberUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import space.eliseev.iplatform.clients.BaseEntityClient;
import space.eliseev.iplatform.config.StockConfig;
import space.eliseev.iplatform.model.BaseEntity;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaseEntityServiceImpl implements BaseEntityService {

    private static final String ERROR = "Error converting JSON string to Java object. "
            + "The JSON string to be converted is: ";
    private final StockConfig stockConfig;
    private final BaseEntityClient baseEntityClient;

    @Override
    public Optional<BaseEntity> getDataByStockConfigId(@NonNull String id) {

        if (NumberUtils.isDigits(id)) {
            int number = Integer.parseInt(id);
            if ((number >= 0) && (number < stockConfig.getUrls().size())) {
                URI determinedBasePathUri = URI.create(stockConfig.getUrls().get(number));
                ResponseEntity<String> response = baseEntityClient.getBaseEntityByUrl(determinedBasePathUri);
                HttpHeaders headers = response.getHeaders();
                String json = response.getBody();
                return Optional.of(new BaseEntity(headers.getDate(), convertStringToObject(json).orElse(null)
                        , determinedBasePathUri.toString()));
            }
        }
        return Optional.empty();
    }

    public Optional<Object> convertStringToObject(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Optional.of(objectMapper.readValue(json, Object.class));
        } catch (JsonProcessingException e) {
            log.error(ERROR + "\n" + json);
        }
        return Optional.empty();
    }

}
