package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repository.ItemRepository;

import java.util.List;

import entity.Item;


/**
 *
 * @author laste
 */
@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
    
    @Override
    @Transactional
    public Item getById(int id){
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    
    @Override
    @Transactional
    public void deleteItem(int id){
        itemRepository.deleteById(id);
    }
    
}
