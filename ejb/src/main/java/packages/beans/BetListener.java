package packages.beans;


import packages.entities.Bet;

import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

public class BetListener {

    @PrePersist
    void betPrePersist(Bet bet) {
        bet.setValue(bet.getValue() + bet.getValue()*8/100);
    }

    @PostRemove
    void betPostRemove(Bet bet) {
        System.out.println("Ставка снята пользователем");
    }

    @PreRemove
    void betPreRemove(Bet bet) {
        bet.setValue(0);
        System.out.println(String.format("Ставка на %s удаляется, её размер... %d", bet.getItem().getNameItem(), bet.getValue()));
    }
}
