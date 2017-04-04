package packages.beans;

import packages.dao.CustomerDAO;
import packages.entities.Customer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CustomerBean {

    @EJB
    CustomerDAO customerDAO;

    public List<Customer> getAllCustomers() {
        return customerDAO.selectCustomers();
    }
}
