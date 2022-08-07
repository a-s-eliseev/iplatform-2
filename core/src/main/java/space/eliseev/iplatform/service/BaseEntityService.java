package space.eliseev.iplatform.service;

import space.eliseev.iplatform.model.BaseEntity;

import java.util.Optional;

public interface BaseEntityService {

   Optional<BaseEntity> getDataByStockConfigId(Integer id);

}
