package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.model.BaseEntity;

@Repository
public interface BaseEntityRepository extends MongoRepository<BaseEntity, String> {
}
