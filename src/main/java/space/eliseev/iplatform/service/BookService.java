package space.eliseev.iplatform.service;


import lombok.NonNull;
import space.eliseev.iplatform.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void save(Book book);

    List<Book> findAll();

    Optional<Book> findById(@NonNull Integer id);

}



