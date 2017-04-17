package packages.beans;

import packages.dao.ItemDAO;
import packages.entities.Item;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class ItemBean {

    @EJB
    ItemDAO itemDAO;

    @Transactional
    public List<Item> getItems() {
        List<Item> items = itemDAO.selectItems();
        return items;
    }
}
