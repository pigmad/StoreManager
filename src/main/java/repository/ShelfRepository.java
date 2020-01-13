package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Shelf;

/**
 *
 * @author laste
 */
@Repository("shelfRepository")
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
    Shelf findById(int id);

    Shelf findByName(String name);
}

