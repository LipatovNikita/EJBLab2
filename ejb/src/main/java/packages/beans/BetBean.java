package packages.beans;

import packages.dao.BetDAO;
import packages.entities.Bet;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BetBean {

    List<Bet> bets;

    @EJB
    BetDAO betDAO;

    public String getBetsByIdCustomer(int id_customer) {
        bets = betDAO.selectBets(id_customer);
        return "bets";
    }

    public String deleteBetById(int id) {
        betDAO.deleteBet(id);
        return "bets";
    }

    public List<Bet> getBets() {
        return bets;
    }
}
