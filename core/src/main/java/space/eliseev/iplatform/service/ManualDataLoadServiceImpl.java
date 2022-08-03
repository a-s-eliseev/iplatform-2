package space.eliseev.iplatform.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import space.eliseev.iplatform.clients.DataLoadClient;
import space.eliseev.iplatform.config.StockConfig;
import space.eliseev.iplatform.model.BaseEntity;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManualDataLoadServiceImpl implements ManualDataLoadService {

    private final StockConfig stockConfig;
    private final DataLoadClient dataLoadClient;

    @Override
    public Optional<BaseEntity> getDataByStockConfigId(@NonNull Integer id) {
        if ((id >= 0) && (id < stockConfig.getUrls().size())) {
            URI determinedBasePathUri = URI.create(stockConfig.getUrls().get(id));
            HttpHeaders headers = dataLoadClient.getBaseEntityByUrl(determinedBasePathUri).getHeaders();
            Object data = dataLoadClient.getBaseEntityByUrl(determinedBasePathUri).getBody();
            BaseEntity baseEntity = new BaseEntity(headers.getDate(), data, determinedBasePathUri.toString());
            return Optional.of(baseEntity);
        }
        return Optional.empty();
    }

}
