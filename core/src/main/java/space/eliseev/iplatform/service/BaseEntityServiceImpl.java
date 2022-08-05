package space.eliseev.iplatform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import space.eliseev.iplatform.clients.BaseEntityClient;
import space.eliseev.iplatform.config.StockConfig;
import space.eliseev.iplatform.exception.ProducerApiNotFoundException;
import space.eliseev.iplatform.model.BaseEntity;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaseEntityServiceImpl implements BaseEntityService {

    private final StockConfig stockConfig;
    private final BaseEntityClient baseEntityClient;

    @Override
    public Optional<BaseEntity> getDataByStockConfigId(@NonNull Integer id) throws JsonProcessingException {
        try {
            if ((id >= 0) && (id < stockConfig.getUrls().size())) {
                URI determinedBasePathUri = URI.create(stockConfig.getUrls().get(id));
                ResponseEntity<String> response = baseEntityClient.getBaseEntityByUrl(determinedBasePathUri);
                HttpHeaders headers = response.getHeaders();
                String json = response.getBody();
                BaseEntity baseEntity = new BaseEntity(headers.getDate(), convertStringToObject(json)
                        , determinedBasePathUri.toString());
                return Optional.of(baseEntity);
            } else {
                throw new ProducerApiNotFoundException();
            }
        } catch (ProducerApiNotFoundException e) {
            String error = "Producer API not defined";
            log.error(error);
            throw e;
        }
    }
    public Object convertStringToObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Object.class);
        } catch (JsonProcessingException e) {
            String error = "Error converting JSON string to Java object";
            log.error(error);
            throw e;
        }
    }

}
