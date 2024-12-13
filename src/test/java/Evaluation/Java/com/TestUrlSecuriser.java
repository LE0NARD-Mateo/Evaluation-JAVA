package Evaluation.Java.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestUrlSecuriser {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "admin", roles = "administrateur")
    public void testUtilisateurEndpointWithAuth() throws Exception {
        mockMvc.perform(get("http://localhost:8080/utilisateur"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "administrateur")
    public void testSalarieEndpointWithAuth() throws Exception {
        mockMvc.perform(get("http://localhost:8080/salarie"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "administrateur")
    public void testConventionEndpointWithAuth() throws Exception {
        mockMvc.perform(get("http://localhost:8080/convention"))
                .andExpect(status().isOk());
    }
}