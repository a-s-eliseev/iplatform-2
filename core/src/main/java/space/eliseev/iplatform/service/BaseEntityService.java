package space.eliseev.iplatform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import space.eliseev.iplatform.model.BaseEntity;

import java.util.Optional;

public interface BaseEntityService {

   Optional<BaseEntity> getDataByStockConfigId(Integer id) throws JsonProcessingException;

}
