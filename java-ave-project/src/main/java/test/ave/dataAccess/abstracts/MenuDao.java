package test.ave.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.ave.entities.concretes.Menu;

public interface MenuDao extends JpaRepository<Menu, Integer> {
	
	@Query(value = "select * from menu m\r\n"
			+ "where m.groups_id=:id",nativeQuery = true)
	List<Menu> findGroupId(@Param("id") int id);
	
	
	/*
	 * 
	 * SELECT m.id, m.menu_name, m.menu_path
FROM menu m
JOIN groups ON groups.id=m.groups_id
JOIN users ON groups.usersId = users.id
WHERE users.id=33
	 * 
	 * */
	
	/*@Query(value =  "select * from menu m,groups g \r\n"
			+ "where m.groups_id = g.id and g.users_id = :id",nativeQuery = true)
	List<Menu> findGroupId(@Param("id") int id);
	*/
	/*
	@Query(value = "SELECT *\r\n"
			+ "FROM menu m\r\n"
			+ "JOIN groups ON groups.id=m.groups_id\r\n"
			+ "JOIN users ON groups.users_id = users.id\r\n"
			+ "WHERE users.id=:id",nativeQuery = true)
	List<Menu> findGroupId(@Param("id") int id);*/
	
}
