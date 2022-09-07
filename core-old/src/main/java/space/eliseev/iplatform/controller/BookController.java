package space.eliseev.iplatform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.model.Book;
import space.eliseev.iplatform.service.BookService;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findAllBooks")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        final Optional<Book> book = bookService.findById(id);
        return book
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND));
    }
}