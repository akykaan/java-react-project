package test.ave.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ave.business.abstracts.MenuService;
import test.ave.dataAccess.abstracts.MenuDao;
import test.ave.entities.concretes.Menu;

@Service
public class MenuManager implements MenuService {


	private MenuDao menuDao;
	
	@Autowired
	public MenuManager(MenuDao menuDao) {
		super();
		this.menuDao = menuDao;
	}
	@Override
	public List<Menu> getAllMenu() {
		return menuDao.findAll();
	}

	@Override
	public List<Menu> getGroupId(int id) {
		return this.menuDao.findGroupId(id);
	}

}
