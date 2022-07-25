package space.eliseev.iplatform.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import space.eliseev.iplatform.model.Book;
import space.eliseev.iplatform.service.BookService;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#getBook(Integer)}
     */
    @Test
    void testGetBook() throws Exception {
        Book book = new Book();
        book.setAuthorName("JaneDoe");
        book.setBookName("Book Name");
        book.setId(1);
        Optional<Book> ofResult = Optional.of(book);
        when(bookService.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findBookById/{id}", 1);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"id\":1,\"bookName\":\"Book Name\",\"authorName\":\"JaneDoe\"}"));
    }

    /**
     * Method under test: {@link BookController#getBook(Integer)}
     */
    @Test
    void testGetBook2() throws Exception {
        when(bookService.findById((Integer) any())).thenReturn(Optional.empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findBookById/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(bookController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":null,\"bookName\":null,\"authorName\":null}"));
    }

    /**
     * Method under test: {@link BookController#getBooks()}
     */
    @Test
    void testGetBooks() throws Exception {
        when(bookService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findAllBooks");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#getBooks()}
     */
    @Test
    void testGetBooks2() throws Exception {
        when(bookService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/findAllBooks");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#saveBook(Book)}
     */
    @Test
    void testSaveBook() throws Exception {
        doNothing().when(bookService).save((Book) any());

        Book book = new Book();
        book.setAuthorName("JaneDoe");
        book.setBookName("Book Name");
        book.setId(1);
        String content = (new ObjectMapper()).writeValueAsString(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

