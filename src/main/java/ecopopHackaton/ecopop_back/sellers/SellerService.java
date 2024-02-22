package ecopopHackaton.ecopop_back.sellers;

import java.util.List;

import org.springframework.stereotype.Service;

import ecopopHackaton.ecopop_back.interfaces.IGenericLimitedService;

@Service
public class SellerService implements IGenericLimitedService<Seller> {

    SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    
    public List<Seller> getAll() {
        
        List<Seller> sellers = repository.findAll();
        return sellers;
    }

    @Override
    public Seller getById(Long id) throws Exception {
        Seller seller = repository.findById(id).orElseThrow(() -> new SellerNotFoundException("Seller not found"));
        return seller;
    }
    
    
}
