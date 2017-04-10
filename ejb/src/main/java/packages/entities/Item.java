package packages.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    private int idItem;
    private String nameItem;
    private int countItem;
    private Seller sellerBySeller;
    private Set<Bet> bets;

    @Id
    @Column(name = "id_item", nullable = false)
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Basic
    @Column(name = "name_item", nullable = false, length = 45)
    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    @Basic
    @Column(name = "count_item", nullable = false)
    public int getCountItem() {
        return countItem;
    }

    public void setCountItem(int countItem) {
        this.countItem = countItem;
    }

    @ManyToOne
    @JoinColumn(name = "seller", referencedColumnName = "id_seller", nullable = false)
    public Seller getSellerBySeller() {
        return sellerBySeller;
    }

    public void setSellerBySeller(Seller sellerBySeller) {
        this.sellerBySeller = sellerBySeller;
    }

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }
}
