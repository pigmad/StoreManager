package entity;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author laste
 */
@Entity
@Table (name="tab_shelf")
public class Shelf implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "idShelf")
    private int idShelf;
   
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idStore")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;
     
    @Column(name = "name", unique=true)
    private String name;
   
    public Shelf() {
    }
    
    public Shelf(int idShelf, String name) {
        this.idShelf = idShelf;
        this.name = name;
    }

    public int getIdShelf() {
        return idShelf;
    }

    public void setIdShelf(int idShelf) {
        this.idShelf = idShelf;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    
}
