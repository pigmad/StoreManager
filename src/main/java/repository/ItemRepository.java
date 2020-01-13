package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Item;

/**
 *
 * @author laste
 */
@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer> {
    public Item findById(int id);
}

