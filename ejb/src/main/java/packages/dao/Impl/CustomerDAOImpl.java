package packages.dao.Impl;

import packages.dao.CustomerDAO;
import packages.entities.Customer;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext(unitName = "production")
    EntityManager entityManager;
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("production");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void editCustomer(int id, String name, String address) {
        Customer customer = entityManager.find(Customer.class, id);
        customer.setName(name);
        customer.setAddress(address);
        entityManager.setFlushMode(FlushModeType.COMMIT);
        entityManager.flush();
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> selectCustomers() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> selectAllCustomerCriteriaQuery = criteriaBuilder.createQuery(Customer.class); // собирает отдельны элементы для объектного представления запроса
        Root<Customer> customerRoot = selectAllCustomerCriteriaQuery.from(Customer.class); // начальная точка - сущность, содержащая свойства для запроса
        selectAllCustomerCriteriaQuery.select(customerRoot);
        TypedQuery<Customer> selectAllCustomerQuery = entityManager.createQuery(selectAllCustomerCriteriaQuery);
        return selectAllCustomerQuery.getResultList();
    }
}
