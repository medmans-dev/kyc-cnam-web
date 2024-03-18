package ws.cnam.kyccnamweb.metier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ws.cnam.kyccnamweb.metier.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, String>, JpaSpecificationExecutor<Personne>{

	Personne findByNni(String nni);

}
