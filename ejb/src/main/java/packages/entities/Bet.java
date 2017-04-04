package packages.entities;

import javax.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "value_bet", nullable = false)
    private int value;

    @ManyToOne
    @JoinColumn(name = "customer", nullable=false)
    Customer customer;
//    @ManyToOne
//    Item item;

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
}
