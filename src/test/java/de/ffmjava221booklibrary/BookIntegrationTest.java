package de.ffmjava221booklibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBookList() throws Exception {
        //given

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                        [
                            {
                                "isbn": "1234",
                                "title": "Krieg der Sterne",
                                "author": "author",
                                "type": "EBOOK"
                            },
                            {
                                "isbn": "5667",
                                "title": "Buch zwei",
                                "author": "author2",
                                "type": "AUDIOBOOK"
                            }
                        ]
                    """));
    }

    @Test
    void testGetBook() throws Exception {
        //given
        String isbn = "1234";
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books/"+isbn))
                //then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                    {
                        "isbn": "1234",
                        "title": "Krieg der Sterne",
                        "author": "author",
                        "type": "EBOOK"
                    }
                    """));
    }

    @Test
    @DirtiesContext
    void addBook() throws Exception {
        //given
        mockMvc.perform(MockMvcRequestBuilders.put("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "isbn": "1122",
                                "title": "title",
                                "author": "author",
                                "type": "EBOOK"
                            }
                            """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "isbn": "1122",
                        "title": "title",
                        "author": "author",
                        "type": "EBOOK"
                    }
                    """));
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books/1122"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                        "isbn": "1122",
                        "title": "title",
                        "author": "author",
                        "type": "EBOOK"
                    }
                    """));
    }

    @Test
    void deleteBook() throws Exception {
        //given
        String isbn = "1234";
        //when
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/"+isbn))
                //then
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                            "isbn": "5667",
                            "title": "Buch zwei",
                            "author": "author2",
                            "type": "AUDIOBOOK"
                        }
                    ]
                    """));
    }
}