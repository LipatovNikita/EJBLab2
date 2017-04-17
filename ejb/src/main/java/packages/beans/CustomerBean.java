package packages.beans;

import packages.dao.CustomerDAO;
import packages.entities.Customer;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CustomerBean {

    Customer customer = new Customer();

    @EJB
    CustomerDAO customerDAO;

    public List<Customer> getAllCustomers() {
        return customerDAO.selectCustomers();
    }

    public String deleteCustomer(int id) {
        customerDAO.deleteCustomerById(id);
        return "index";
    }

    public String addNewCustomer() {
        customerDAO.addCustomer(customer);
        return "index";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
