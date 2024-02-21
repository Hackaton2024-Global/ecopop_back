package ecopopHackaton.ecopop_back.products;

import java.util.List;

import org.springframework.stereotype.Service;

import ecopopHackaton.ecopop_back.interfaces.IGenericFullService;

@Service
public class ProductService implements IGenericFullService <Product> {
    ProductRepository productRepository;

    

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
    public List<Product> getAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    
    public Product getById(Long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));

        return product;
    }
    
}
