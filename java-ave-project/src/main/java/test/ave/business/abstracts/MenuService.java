package test.ave.business.abstracts;



import java.util.List;


import test.ave.entities.concretes.Menu;

public interface MenuService {
	List<Menu> getAllMenu();
	List<Menu> getGroupId(int id);
}