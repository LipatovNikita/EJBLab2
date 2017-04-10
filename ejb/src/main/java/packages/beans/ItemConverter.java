package packages.beans;

import packages.entities.Item;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@FacesConverter(value = "itemConverter")
public class ItemConverter implements Converter {

    @PersistenceContext(unitName = "production")
    EntityManager entityManager;

    @Override
    @Transactional
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Object test = entityManager.find(Item.class, new Integer(value));
        return test;
    }

    @Override
    @Transactional
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String test = String.valueOf(((Item) value).getIdItem());
        return test;
    }
}
