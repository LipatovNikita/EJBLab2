package packages.beans;

import packages.dao.ItemDAO;
import packages.entities.Item;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
