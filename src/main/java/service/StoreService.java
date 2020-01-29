package service;

import entity.Director;
import entity.Seller;
import entity.Shelf;
import entity.Store;
import java.util.List;

/**
 *
 * @author laste
 */
public interface StoreService {
    public List<Store> getStores();
    public Store getById(int id);
    public Store getByCity(String city);
    public void saveStore(Store store);
    
    public boolean login(String mail, String password);
}
