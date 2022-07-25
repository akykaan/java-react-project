package test.ave.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups_id")
    private Group group;
*/
	@Column(name="groups_id")
	private int groups_id;
	
	public User() {}
	
	public User(int id, String email, String password,int groups_id ) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.groups_id = groups_id;
	}
	
	public int getGroups_id() {
		return groups_id;
	}

	public void setGroups_id(int groups_id) {
		this.groups_id = groups_id;
	}

	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password=password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
