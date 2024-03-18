/**
 * 
 */
package ws.cnam.kyccnamweb.metier.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ws.cnam.kyccnamweb.metier.services.EnregistrementService;
import ws.cnam.kyccnamweb.metier.vo.ApiVO;
import ws.cnam.kyccnamweb.metier.vo.AuthApiVO;
import ws.cnam.kyccnamweb.metier.vo.ParamApiVO;
import ws.cnam.kyccnamweb.metier.vo.PersonneVO;


/**
 * @author Med.Mansour.GUEYE
 *
 */
@RestController
public class ApiRestController {
	@Autowired
	EnregistrementService enregistrementService;
//	@Autowired
//	AccountService accountService;
	@Autowired
	ResourceLoader resourceLoader;
	@Value("${api.key}")
	private String apiKey;
	@Value("${api.login}")
	private String login;
	@Value("${api.password}")
	private String password;


	@PostMapping(value = "/api_getNni")
	public ApiVO getVehicule(@RequestBody ParamApiVO param) {
		ApiVO api = null;
		try {
			if(!param.getKey().equals(apiKey)){
				api = new ApiVO();
				api.setMessage("Accès réfusé");
				api.setStatut("403");
				return api;
			}
			PersonneVO personne = this.enregistrementService.getPersonneByNni(param.getValue());
			if(personne==null){
				api = new ApiVO();
				api.setMessage("Aucune données trouvées.");
				api.setStatut("404");
			}else{
				api = setApi(personne);

			}
		} catch (Exception e) {
			//throw e;
			api = new ApiVO();
			api.setMessage("le serveur n'a pas répondu.");
			api.setStatut("500");
		}
		return api;
	}

	private ApiVO setApi(PersonneVO personne) {
		ApiVO api = new ApiVO();
		api.setEtat(personne.getEtat());
		api.setMessage("Success");
		api.setNni(personne.getNni());
		api.setNom(personne.getNom());
		api.setPrenom(personne.getPrenom());
		api.setPerePrenom(personne.getPerePrenom());
		api.setDateNaissance(personne.getDateNaissance());
		api.setLieuNaissance(personne.getLieuNaissance());
		api.setMatriculeCnam(personne.getMatriculeCnam());
		api.setTelephone(personne.getTelephone());
		api.setSexe(personne.getSexe());
		api.setPhoto(personne.getPhoto());
		api.setStatut(personne.getStatut());

		return api;
	}

	@PostMapping(value = "/api_login")
	public AuthApiVO getApiLogin(@RequestBody ParamApiVO param) {
		AuthApiVO resultVo = new AuthApiVO();
		try {
			if(!param.getKey().equals(apiKey)){
				resultVo.setMessage("Accès réfusé");
				resultVo.setStatus(403);
				return resultVo;
			}else if(!param.getLogin().equals(login) || !param.getPassword().equals(password)){
				resultVo.setMessage("Login ou mot de passe incorrect.");
				resultVo.setStatus(404);
				return resultVo;
			}
			else{
				resultVo.setMessage("Utilisateur connecté");
				resultVo.setStatus(200);
			}
		} catch (Exception e) {
			resultVo.setMessage("le serveur n'a pas répondu.");
			resultVo.setStatus(500);
		}
		return resultVo;
	}

}
