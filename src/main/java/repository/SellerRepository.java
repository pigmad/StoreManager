package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Seller;

/**
 *
 * @author laste
 */
@Repository("sellerRepository")
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller findById(int id);

    Seller findByMailAndPassword(String mail, String password);
    
    Seller findByMail(String mail);
    
}

