package space.eliseev.iplatform.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import space.eliseev.iplatform.model.Book;
import space.eliseev.iplatform.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BookServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImpl bookServiceImpl;

    /**
     * Method under test: {@link BookServiceImpl#save(Book)}
     */
    @Test
    void testSave() {
        Book book = new Book();
        book.setAuthorName("JaneDoe");
        book.setBookName("Book Name");
        book.setId(1);
        when(bookRepository.save((Book) any())).thenReturn(book);

        Book book1 = new Book();
        book1.setAuthorName("JaneDoe");
        book1.setBookName("Book Name");
        book1.setId(1);
        bookServiceImpl.save(book1);
        verify(bookRepository).save((Book) any());
        assertEquals("JaneDoe", book1.getAuthorName());
        assertEquals(1, book1.getId().intValue());
        assertEquals("Book Name", book1.getBookName());
    }


    /**
     * Method under test: {@link BookServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Book> bookList = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(bookList);
        List<Book> actualFindAllResult = bookServiceImpl.findAll();
        assertSame(bookList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(bookRepository).findAll();
    }


    /**
     * Method under test: {@link BookServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById() {
        Book book = new Book();
        book.setAuthorName("JaneDoe");
        book.setBookName("Book Name");
        book.setId(1);
        Optional<Book> ofResult = Optional.of(book);
        when(bookRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Book> actualFindByIdResult = bookServiceImpl.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(bookRepository).findById((Integer) any());
    }
}

