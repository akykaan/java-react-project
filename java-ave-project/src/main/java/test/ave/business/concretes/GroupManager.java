package test.ave.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.ave.business.abstracts.GroupService;
import test.ave.dataAccess.abstracts.GroupDao;
import test.ave.entities.concretes.Group;

@Service
public class GroupManager implements GroupService {

	private GroupDao groupDao;
	
	@Autowired
	public GroupManager(GroupDao groupDao) {
		super();
		this.groupDao = groupDao;
	}
	@Override
	public String add(Group group) {
		this.groupDao.save(group);
		return "yeni grup eklendi";
	}

}
