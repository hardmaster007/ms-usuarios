package cl.pruebadespring.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, unique = true, length = 45)
//	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Phone> phones = new ArrayList<>();
	
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date createAt;
	
	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date modified;
	
	@Column(name = "last_login")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date lastLogin;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
		this.modified = new Date();
		this.lastLogin = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	
}
