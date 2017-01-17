package ro.forum.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusers;

	private String email;

	private String nume;

	private String passwd;

	private String prenume;

	private String username;

	//bi-directional many-to-one association to Subiecte
	@OneToMany(mappedBy="user")
	private List<Subiecte> subiectes;

	//bi-directional many-to-one association to Comentarii
	@OneToMany(mappedBy="user")
	private List<Comentarii> comentariis;

	public User() {
	}

	public int getIdusers() {
		return this.idusers;
	}

	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Subiecte> getSubiectes() {
		return this.subiectes;
	}

	public void setSubiectes(List<Subiecte> subiectes) {
		this.subiectes = subiectes;
	}

	public Subiecte addSubiecte(Subiecte subiecte) {
		getSubiectes().add(subiecte);
		subiecte.setUser(this);

		return subiecte;
	}

	public Subiecte removeSubiecte(Subiecte subiecte) {
		getSubiectes().remove(subiecte);
		subiecte.setUser(null);

		return subiecte;
	}

	public List<Comentarii> getComentariis() {
		return this.comentariis;
	}

	public void setComentariis(List<Comentarii> comentariis) {
		this.comentariis = comentariis;
	}

	public Comentarii addComentarii(Comentarii comentarii) {
		getComentariis().add(comentarii);
		comentarii.setUser(this);

		return comentarii;
	}

	public Comentarii removeComentarii(Comentarii comentarii) {
		getComentariis().remove(comentarii);
		comentarii.setUser(null);

		return comentarii;
	}

}