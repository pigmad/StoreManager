package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author laste
 */
@Entity
@Table(name = "tab_store")
public class Store implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "idStore")
    private int idStore;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idDirector")
    private Director manager;
    
    @Column(name = "City")
    private String city;
    
    public Store(){
        
    }

    public Store(int idStore, String city) {
        this.idStore = idStore;
        this.city = city;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Director getManager() {
        return manager;
    }

    public void setManager(Director manager) {
        this.manager = manager;
    }   
    
}
