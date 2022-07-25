package test.ave.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import test.ave.entities.concretes.Group;

public interface GroupDao extends JpaRepository<Group, Integer> {

}
