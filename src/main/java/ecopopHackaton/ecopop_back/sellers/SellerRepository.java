package ecopopHackaton.ecopop_back.sellers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    public Optional<Seller> findBySellerName(String seller);
}
