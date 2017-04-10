package packages.entities;

import javax.persistence.*;

@Entity
@Table(name = "bet", schema = "auction")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bet")
    private int id;
    @Column(name = "value_bet", nullable = false)
    private int value;

    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "item", nullable = true)
    Item item;

    public Bet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
