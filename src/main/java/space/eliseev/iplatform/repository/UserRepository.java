package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findByFirstName(String firstName);
}
