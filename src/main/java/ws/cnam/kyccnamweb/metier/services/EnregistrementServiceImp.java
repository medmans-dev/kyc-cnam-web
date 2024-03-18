package ws.cnam.kyccnamweb.metier.services;

import jakarta.servlet.ServletContext;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ws.cnam.kyccnamweb.metier.dao.PersonneRepository;
import ws.cnam.kyccnamweb.metier.entities.Personne;
import ws.cnam.kyccnamweb.metier.vo.PersonneVO;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 
 * @author Med.Mansour.GUEYE
 *
 */
@Service
public class EnregistrementServiceImp implements EnregistrementService {
//	@Autowired
//	private AccountService accountService;
	@Autowired
	private PersonneRepository personneRepository;
//	@Autowired
//	private LogsService logsService ;
	@Autowired
	ServletContext context;


	@Override
	public String saveImageToStorage(String uploadDirectory, MultipartFile imageFile) {
		try{
			String uniqueFileName = imageFile.getOriginalFilename();

			Path uploadPath = Paths.get(uploadDirectory);
			Path filePath = uploadPath.resolve(uniqueFileName);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			return uniqueFileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] getImage(String imageDirectory, String imageName) {
		try {
			Path imagePath = Paths.get(imageDirectory, imageName);

			if (Files.exists(imagePath)) {
				byte[] imageBytes = Files.readAllBytes(imagePath);
				return imageBytes;
			} else {
				return null; // Handle missing images
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PersonneVO getPersonneByNni(String nni) {
		try {
			PersonneVO personneVO = null;
			Personne personne = this.personneRepository.findByNni(nni);
			personneVO = new DozerBeanMapper().map(personne, PersonneVO.class);

			return personneVO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Delete an image
	public String deleteImage(String imageDirectory, String imageName) throws IOException {
		Path imagePath = Paths.get(imageDirectory, imageName);

		if (Files.exists(imagePath)) {
			Files.delete(imagePath);
			return "Success";
		} else {
			return "Failed"; // Handle missing images
		}
	}


}
