package packages.dao;

import packages.entities.Item;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ItemDAO {
    List<Item> selectItems();
}
