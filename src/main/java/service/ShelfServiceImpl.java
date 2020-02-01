package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repository.ShelfRepository;

import java.util.List;

import entity.Shelf;
import entity.Store;

/**
 *
 * @author laste
 */
@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    @Transactional
    public List<Shelf> getShelves() {
        return shelfRepository.findAll();
    }

    @Override
    @Transactional
    public Shelf getById(int id) {
        return shelfRepository.findById(id);
    }

    @Override
    @Transactional
    public Shelf getByName(String name){
        return shelfRepository.findByName(name);
    }
    
    @Override
    @Transactional
    public void saveShelf(Shelf shelf) {
        shelfRepository.save(shelf);
    }
    
    @Override
    @Transactional
    public void deleteShelf(int id){
        shelfRepository.deleteById(id);
    }
    
    
}
