package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repository.SellerRepository;

import java.util.List;

import entity.Seller;

/**
 *
 * @author laste
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    @Transactional
    public List<Seller> getSellers() {
        return sellerRepository.findAll();
    }

    @Override
    @Transactional
    public Seller getById(int id) {
        return sellerRepository.findById(id);
    }

    @Override
    @Transactional
    public Seller getByMail(String mail) {
        return sellerRepository.findByMail(mail);
    }

    @Override
    @Transactional
    public void saveSeller(Seller seller) {
        sellerRepository.save(seller);
    }
    
    @Override
    @Transactional
    public void deleteSeller(int id) {
        sellerRepository.deleteById(id);
    }
    
}
