package ecopopHackaton.ecopop_back.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ecopopHackaton.ecopop_back.sellers.Seller;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc (addFilters = false)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ProductService service;

    @Test
    @DisplayName("Should return a list of products")

    void testIndex() throws JsonProcessingException, Exception{

        List<Product> products = new ArrayList<>();
        Seller seller = new Seller("Pepe", "666555333", "pepe@google.com");
        seller.setSellerName("Pepe");
        Product sillon = new Product("Sillón", "Los sillones ingleses", (long) 230, null, seller);
        sillon.setId(1L);

        when(service.getAll()).thenReturn(products);
        MockHttpServletResponse response = (MockHttpServletResponse) mockMvc.perform(get("/api/v1/products")
            .accept(MediaType.APPLICATION_JSON)
            .content("applicaton/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse();

            assertThat(response.getStatus(), is(HttpStatus.OK.value()));
            assertThat(response.getContentAsString(), equalTo(mapper.writeValueAsString(products)));

    }

}
