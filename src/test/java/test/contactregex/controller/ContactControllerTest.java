package test.contactregex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import test.contactregex.model.Contact;
import test.contactregex.repository.ContactRepository;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {
    private static final String URL = "/hello/contacts";
    private static final String FIRST_REGEX = "^A.*$";
    private static final String SECOND_REGEX = "^.*[aei].*$";
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void init(@Autowired ContactRepository contactRepository) {
        contactRepository.save(new Contact("Nathan"));
        contactRepository.save(new Contact("Alan"));
        contactRepository.save(new Contact("Morena"));
        contactRepository.save(new Contact("Jewel"));
    }

    @Test
    public void testFirstRegexOk() throws Exception {
        String expected = "[{\"id\":1,\"name\":\"Nathan\"},{\"id\":3,\"name\":\"Morena\"},"
                + "{\"id\":4,\"name\":\"Jewel\"}]";
        String actual = mockMvc.perform(get(URL)
                .param("nameFilter", FIRST_REGEX)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(expected, actual);
    }

    @Test
    public void testSecondRegexOk() throws Exception {
        String expected = "[]";
        String actual = mockMvc.perform(get(URL)
                .param("nameFilter", SECOND_REGEX)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(expected, actual);
    }

    @Test
    public void testNullRegex() {
        assertThrows(IllegalArgumentException.class, () -> mockMvc.perform(get(URL)
                .param("nameFilter", null)));
    }
}
