package ro.forum.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subiecte database table.
 * 
 */
@Entity
@NamedQuery(name="Subiecte.findAll", query="SELECT s FROM Subiecte s")
public class Subiecte implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int idsubiecte;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private String denumire;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idusers")
	private User user;

	//bi-directional many-to-one association to Comentarii
	@OneToMany(mappedBy="subiecte")
	private List<Comentarii> comentariis;

	public Subiecte() {
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

	public List<Comentarii> getComentariis() {
		return this.comentariis;
	}

	public void setComentariis(List<Comentarii> comentariis) {
		this.comentariis = comentariis;
	}

	public Comentarii addComentarii(Comentarii comentarii) {
		getComentariis().add(comentarii);
		comentarii.setSubiecte(this);

		return comentarii;
	}

	public Comentarii removeComentarii(Comentarii comentarii) {
		getComentariis().remove(comentarii);
		comentarii.setSubiecte(null);

		return comentarii;
	}

}