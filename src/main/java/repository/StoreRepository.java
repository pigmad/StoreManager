package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Store;

/**
 *
 * @author laste
 */
@Repository("storeRepository")
public interface StoreRepository extends JpaRepository<Store, Integer> {
    public Store findById(int id);
    
    public Store findByCity(String city);
}

