package Evaluation.Java.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
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
        mockMvc.perform(get("/utilisateur"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "administrateur")
    public void testSalarieEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/salarie"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "administrateur")
    public void testConventionEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/convention"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSalarieEndpoint() throws Exception  {

        mockMvc.perform(get("/salarie"))
                .andExpect(status().isForbidden());

    }

    @Test
    public void testConventionEndpoint() throws Exception  {

        mockMvc.perform(get("/convention"))
                .andExpect(status().isForbidden());

    }

    @Test
    public void testUtilisateurEndpoint() throws Exception  {

        mockMvc.perform(get("/utilisateur"))
                .andExpect(status().isForbidden());

    }
}