package test.ave.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.ave.business.abstracts.GroupService;
import test.ave.entities.concretes.Group;

@RestController
@RequestMapping("api/group")
@CrossOrigin
public class GroupController {

	
	private GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	@PostMapping("/getallgroup")
	public String getAllGroup(@RequestBody Group group) {
		return this.groupService.add(group);
	}
}
