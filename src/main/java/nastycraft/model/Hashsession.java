package nastycraft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="hashsession")
public class Hashsession implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String hashsession;
	
	public Hashsession() {}
	
	public Hashsession(String username, String hashsession) {
		this.username = username;
		this.hashsession = hashsession;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashsession() {
		return hashsession;
	}

	public void setHashsession(String hashsession) {
		this.hashsession = hashsession;
	}

	@Override
	public String toString() {
		return "Hashsession [id=" + id + ", username=" + username + ", hashsession=" + hashsession + "]";
	}
	
	
	
	
	
	}
	
