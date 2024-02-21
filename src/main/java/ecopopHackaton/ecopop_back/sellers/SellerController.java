package ecopopHackaton.ecopop_back.sellers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecopopHackaton.ecopop_back.interfaces.IGenericLimitedService;

@RestController
@RequestMapping(path = "${api-endpoint}/sellers")
public class SellerController {
    IGenericLimitedService<Seller> service;

    public SellerController(IGenericLimitedService<Seller> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Seller> index() {
        List<Seller> sellers = service.getAll();
        return sellers;
    }
    
}
