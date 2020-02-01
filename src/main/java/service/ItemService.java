package service;

import java.io.Serializable;
import java.util.List;

import entity.Item;

/**
 *
 * @author laste
 */
public interface ItemService extends Serializable{
    public List<Item> getItems();    
    public Item getById(int id);
    public void saveItem(Item item);
    public void deleteItem(int id);
}
