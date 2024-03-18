package ws.cnam.kyccnamweb.metier.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



/**
 * @author Med.Mansour.GUEYE
 *
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name="PERSONNE")
public class Personne {
	
	@Id
	@EqualsAndHashCode.Include
	private String nni;
	private String nom;
	private String prenom;
	private String perePrenom;
	private String dateNaissance;
	private String lieuNaissance;
	private String matriculeCnam;
	private String telephone;
	private String sexe;
	private String etat;
	private String statut;
	private String photo;
	private byte[] photoArray;
	@ManyToOne
	private Personne pere;
	
	
	public Personne() {
		super();
	}
	public Personne(String nni) {
		super();
		this.nni = nni;
	}
	
}
