package ws.cnam.kyccnamweb.metier.services;

import org.springframework.web.multipart.MultipartFile;
import ws.cnam.kyccnamweb.metier.vo.PersonneVO;

public interface EnregistrementService {

	public String saveImageToStorage(String uploadDirectory, MultipartFile imageFile);
	public byte[] getImage(String imageDirectory, String imageName);
	public PersonneVO getPersonneByNni(String nni);
}
