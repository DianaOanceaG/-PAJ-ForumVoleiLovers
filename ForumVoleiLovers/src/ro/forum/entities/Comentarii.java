package ro.forum.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comentarii database table.
 * 
 */
@Entity
@NamedQuery(name="Comentarii.findAll", query="SELECT c FROM Comentarii c")
public class Comentarii implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcomentarii;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String denumire;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idusers")
	private User user;

	//bi-directional many-to-one association to Subiecte
	@ManyToOne
	@JoinColumn(name="idsubiecte", referencedColumnName="idsubiecte")
	private Subiecte subiecte;

	public Comentarii() {
	}

	public int getIdcomentarii() {
		return this.idcomentarii;
	}

	public void setIdcomentarii(int idcomentarii) {
		this.idcomentarii = idcomentarii;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subiecte getSubiecte() {
		return this.subiecte;
	}

	public void setSubiecte(Subiecte subiecte) {
		this.subiecte = subiecte;
	}

}