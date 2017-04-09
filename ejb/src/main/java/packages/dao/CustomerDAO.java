package packages.dao;

import packages.entities.Customer;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerDAO {
    void addCustomer(Customer customer);
    void deleteCustomerById(int id);
    List<Customer> selectCustomers();
}
