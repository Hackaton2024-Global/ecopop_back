package ecopopHackaton.ecopop_back.products;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecopopHackaton.ecopop_back.interfaces.IGenericFullService;

@RestController
@RequestMapping(path = "${api-endpoint}/products")
public class ProductController {

    IGenericFullService <Product> service;

    public ProductController(IGenericFullService<Product> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Product> index(){
        List<Product> products = service.getAll();
        return products;
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Product> getOneById(@PathVariable("id") Long id) throws Exception {

        Product product = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(product);
    }
}
