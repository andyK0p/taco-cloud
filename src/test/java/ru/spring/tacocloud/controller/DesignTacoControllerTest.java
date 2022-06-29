package ru.spring.tacocloud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DesignTacoController.class)
public class DesignTacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowDesignForm() throws Exception {
        mockMvc.perform(get("/design"))
            .andExpect(status().isOk())
            .andExpect(view().name("design"))
            .andExpect(model().attributeExists("wrap", "protein", "veggies", "cheese", "sauce", "design"));
    }

    @Test
    public void testProcessDesign() throws Exception {
        mockMvc.perform(post("/design"))
            .andExpect(status().is3xxRedirection());
    }
}