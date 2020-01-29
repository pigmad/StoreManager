package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repository.StoreRepository;
import repository.SellerRepository;
import repository.DirectorRepository;

import java.util.List;

import entity.Director;
import entity.Seller;
import entity.Store;

/**
 *
 * @author laste
 */
@Service
public class StoreServiceImpl implements StoreService {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired 
    private SellerRepository sellerRepository;
    
    @Autowired
    private DirectorRepository directorRepository;
    
    
    @Override
    @Transactional
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    @Override
    @Transactional
    public Store getById(int id){
        return storeRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Store getByCity(String city){
        return storeRepository.findByCity(city);
    }
    
    @Override
    @Transactional
    public void saveStore(Store store) {
        storeRepository.save(store);
    }
    
    @Override
    @Transactional
    public boolean login(String mail, String password){
        boolean logged=false;
        Director director = directorRepository.findByMail(mail);
        Seller seller = sellerRepository.findByMail(mail);
        if (director!=null){
            logged=director.getPassword().equals(password);
        }
        if (seller!=null){
            logged=seller.getPassword().equals(password);
        }
        return logged;
    }
     
}

