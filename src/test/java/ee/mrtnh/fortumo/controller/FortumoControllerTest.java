package ee.mrtnh.fortumo.controller;

import ee.mrtnh.fortumo.service.FortumoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FortumoController.class)
class FortumoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FortumoService fortumoService;

    @Test
    public void shouldReturnStatusOk() throws Exception {
        this.mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content("1")).andExpect(status().isOk());
    }
}