package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import repository.DirectorRepository;

import entity.Director;

/**
 *
 * @author laste
 */
@Service
public class DirectorServiceImpl implements DirectorService {
    
    @Autowired
    private DirectorRepository directorRepository;

    @Override
    @Transactional
    public List<Director> getDirectors() {
        return directorRepository.findAll();
    }

    @Override
    @Transactional
    public Director getById(int id) {
        return directorRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Director getByLastName(String lastName){
        return directorRepository.findByLastName(lastName);
    }

    @Override
    @Transactional
    public Director getByMail(String mail) {
        return directorRepository.findByMail(mail);
    }

    @Override
    @Transactional
    public void saveDirector(Director director) {
        directorRepository.save(director);
    }
    
}
