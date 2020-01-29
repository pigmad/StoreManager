package service;

import java.util.List;

import entity.Director;

/**
 *
 * @author laste
 */
public interface DirectorService {
    public List<Director> getDirectors();
    public Director getById(int id);
    public Director getByLastName(String lastName);
    public Director getByMail(String mail);
    public void saveDirector(Director director);
}
