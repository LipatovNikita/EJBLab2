package packages.dao.Impl;

import packages.dao.ItemDAO;
import packages.entities.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ItemDAOImpl implements ItemDAO {

    @PersistenceContext(unitName = "production")
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Item> selectItems() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> selectItems = criteriaBuilder.createQuery(Item.class);
        Root<Item> customerRoot = selectItems.from(Item.class);
        selectItems.select(customerRoot);
        TypedQuery<Item> selectAllCustomerQuery = entityManager.createQuery(selectItems);
        return selectAllCustomerQuery.getResultList();
    }
}
