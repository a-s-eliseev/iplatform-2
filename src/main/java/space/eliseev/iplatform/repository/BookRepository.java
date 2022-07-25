package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import space.eliseev.iplatform.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
