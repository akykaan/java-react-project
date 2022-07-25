package test.ave.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.ave.business.abstracts.MenuService;
import test.ave.entities.concretes.Menu;

@RestController
@RequestMapping("api/menu")
@CrossOrigin
public class MenuController {

	private MenuService menuService;
	
	@Autowired
	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	@GetMapping("/getallmenu/{id}")
	public List<Menu> getAllUser(@PathVariable int id) {
		return this.menuService.getGroupId(id);
	}
	
	@GetMapping("/getallmenu")
	public List<Menu> getAllUser() {
		return this.menuService.getAllMenu();
	}
	
}
