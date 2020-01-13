package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Director;

/**
 *
 * @author laste
 */
@Repository("directorRepository")
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Director findById(int id);

    Director findByLastName(String lastName);
    
    Director findByMailAndPassword(String mail, String password);
    
    Director findByMail(String email);
    
}

