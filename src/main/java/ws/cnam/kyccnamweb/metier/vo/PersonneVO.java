package ws.cnam.kyccnamweb.metier.vo;

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
public class PersonneVO {
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
	private PersonneVO pere;
	
	
	public PersonneVO() {
		super();
	}
	public PersonneVO(String nni) {
		super();
		this.nni = nni;
	}
	
}
