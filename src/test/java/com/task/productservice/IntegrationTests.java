package com.task.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private String authenticateAndGetToken() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/authenticate")
                        .contentType("application/json")
                        .content("{\"username\":\"testAuthenticateUser\",\"password\":\"test\"}"))
                .andReturn();
        return result.getResponse().getContentAsString();
    }

    @Test
    void testAddUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                        .contentType("application/json")
                        .content("{\"username\":\"testAuthenticateUser\",\"password\":\"test\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testAddProducts() throws Exception {
        String token = authenticateAndGetToken();
        mockMvc.perform(MockMvcRequestBuilders.post("/product/add")
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .content("{\"records\":[{\"entryDate\":\"03-01-2023\",\"itemCode\":\"11111\",\"itemName\":\"Test Inventory 1\",\"itemQuantity\":\"20\",\"status\":\"Paid\"}]}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/all")
                        .header("Authorization", "Bearer " + authenticateAndGetToken()))
                .andExpect(status().isOk());
    }
}
