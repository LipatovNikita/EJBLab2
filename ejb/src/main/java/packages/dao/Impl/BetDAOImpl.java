package packages.dao.Impl;

import packages.dao.BetDAO;
import packages.entities.Bet;
import packages.entities.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class BetDAOImpl implements BetDAO {

    @PersistenceContext(unitName = "production")
    EntityManager entityManager;

    @Override
    public void addBet(Bet bet, int id_customer) {
        Customer customerForBet = entityManager.find(Customer.class, id_customer);
        bet.setCustomer(customerForBet);
        entityManager.persist(bet);
    }

    @Override
    public void deleteBet(int id) {
        Bet bet = entityManager.find(Bet.class, id);
        entityManager.remove(bet);
    }

    @Override
    public List<Bet> selectBets(int id_customer) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bet> selectAllBet = criteriaBuilder.createQuery(Bet.class);
        Root<Bet> betRoot = selectAllBet.from(Bet.class);
        selectAllBet.where(criteriaBuilder.equal(betRoot.get("customer"), id_customer));
        TypedQuery<Bet> bets = entityManager.createQuery(selectAllBet);
        return bets.getResultList();
    }
}
