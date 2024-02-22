package ecopopHackaton.ecopop_back.products;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecopopHackaton.ecopop_back.sellers.Seller;

public class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {

        Seller seller = new Seller("Pepe", "666555333", "pepe@google.com");
        seller.setSellerName("Pepe");
        product = new Product("Sillón", "Los sillones ingleses", (long) 230, null, seller);
        product.setId(1L);
    }
    @Test
    void testProductHave7Atributes() {
        java.lang.reflect.Field[] fields = product.getClass().getDeclaredFields();
        assertThat(fields.length, is(7));
    }

    @Test
    void testProductHaveIdProductNameDescripPriceSeller(){
        assertThat(product.getId(), is(1L));
        assertThat(product.getProduct_name(), is("Sillón"));
        assertThat(product.getDescrip(), is("Los sillones ingleses"));
        assertThat(product.getPrice(), is(230L));
        assertThat(product.getSeller().getSellerName(), is("Pepe"));
    }
}