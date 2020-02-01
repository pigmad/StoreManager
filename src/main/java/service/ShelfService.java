package service;

import java.util.List;
import entity.Shelf;
import entity.Item;
import entity.Store;

/**
 *
 * @author laste
 */
public interface ShelfService {
    public List<Shelf> getShelves();
    public Shelf getById(int id);
    public Shelf getByName(String name);
    public void saveShelf(Shelf shelf);
    public void deleteShelf(int id);
}
