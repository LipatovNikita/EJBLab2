package packages.beans;

import packages.dao.BetDAO;
import packages.entities.Bet;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BetBean implements Serializable {

    List<Bet> bets;
    Bet bet = new Bet();
    int id_customer;

    @EJB
    BetDAO betDAO;

    public String getBetsByIdCustomer(int id_customer) {
        this.id_customer = id_customer;
        bets = betDAO.selectBets(id_customer);
        return "bets";
    }

    public String deleteBetById(int id) {
        betDAO.deleteBet(id);
        return "bets";
    }

    public String addNewBet() {
        betDAO.addBet(bet, this.id_customer);
        return "index";
    }

    public List<Bet> getBets() {
        return bets;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public int getId_customer() {
        return id_customer;
    }
}
