package packages.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Seller {
    private int idSeller;
    private String name;
    private int rate;
    private Set<Item> items;

    @Id
    @Column(name = "id_seller", nullable = false)
    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "rate", nullable = false)
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @OneToMany(mappedBy = "sellerBySeller")
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
