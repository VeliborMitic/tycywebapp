package nastycraft.model;

import java.io.Serializable;
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
	private String ip;
	
	public Hashsession() {}

	public Hashsession(String username, String hashsession, String ip) {
		this.username = username;
		this.hashsession = hashsession;
		this.ip = ip;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

	
	
}
