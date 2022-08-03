package space.eliseev.iplatform.service;

import space.eliseev.iplatform.model.BaseEntity;
import java.util.Optional;

public interface ManualDataLoadService {

   Optional<BaseEntity> getDataByStockConfigId(Integer id);

}
