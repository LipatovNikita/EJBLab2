package packages.dao;

import packages.entities.Bet;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BetDAO {
    void addBet(Bet bet);
    void deleteBet(int id);
    List<Bet> selectBets(int id_customer);
}
