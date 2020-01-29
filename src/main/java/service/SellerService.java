package service;

import java.util.List;

import entity.Seller;

/**
 *
 * @author laste
 */
public interface SellerService {
    public List<Seller> getSellers();
    public Seller getById(int id);
    public Seller getByMail(String mail);
    public void saveSeller(Seller seller);
    public void deleteSeller(int id);
}

