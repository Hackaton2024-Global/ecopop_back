package ecopopHackaton.ecopop_back.sellers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SellerTest {
   
    
    Seller seller;
    

    @BeforeEach
    void setUp() {

        seller = new Seller("Pepe", "666555333", "pepe@google.com");
        seller.setId(1L);
        seller.setSellerName("Pepe");
        seller.setTlf("666555333");
        seller.setEmail("pepe@google.com");

    }

    @Test
    void testsellerHaveIdSellernameEmailTlf() {
        assertThat(seller.getId(), is(1L));
        assertThat(seller.getSellerName(), is("Pepe"));
        assertThat(seller.getEmail(), is("pepe@google.com"));
        assertThat(seller.getTlf(), is("666555333"));
       
    }

    @Test
    void testProductHave5Atributes() {
        java.lang.reflect.Field[] fields = seller.getClass().getDeclaredFields();
        assertThat(fields.length, is(5));
    }

}
