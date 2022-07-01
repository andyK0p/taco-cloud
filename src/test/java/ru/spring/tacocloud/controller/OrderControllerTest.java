package ru.spring.tacocloud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.spring.tacocloud.data.IngredientRepository;
import ru.spring.tacocloud.data.OrderRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderRepository orderRepo;
    @MockBean
    private IngredientRepository ingredientRepo;

    @Test
    public void testOrderForm() throws Exception {
        mockMvc.perform(get("/orders/current"))
            //.andExpect(status().isOk())
            .andExpect(view().name("orderForm"))
            //.andExpect(model().attributeExists("order"))
            .andExpect(content().string(containsString("Order your taco creations!")));
    }

    @Test
    public void testProcessOrder() throws Exception {
        mockMvc.perform(post("/orders"))
            .andExpect(status().is3xxRedirection());
    }
}