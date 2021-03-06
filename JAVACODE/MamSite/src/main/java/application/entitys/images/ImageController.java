package application.entitys.images;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("images")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {

	@Autowired
	private ImageRep imageRep;

	@GetMapping("/url")
	public List<String> getAllImages() {

		try {
			return imageRep.findAllUrl();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@GetMapping("/db/images/add")
	public List<String> inertImages() {
		File directoryPath = new File("D:\\School 2021 2022\\mam project(click here trust)\\JAVACODE\\MamSite\\Images\\Gallery");
		File localFiles[] = directoryPath.listFiles();
		List<String> localFileUrls = new ArrayList<>();
		List<String> databaseFileList = new ArrayList<>();
		databaseFileList = getAllImages();
		
		for (File file : localFiles) {
			localFileUrls.add(file.getAbsolutePath());
		}
		
		
		
		List<String> toAdd = new ArrayList<>();
		
		
		
		toAdd = compareToReturnNotFound(localFileUrls, databaseFileList);
		
		
		for( String url : toAdd) {
			Image newImg = new Image(url);
			imageRep.save(newImg);
		}
		return toAdd;
	}
	
	public List<String> compareToReturnNotFound(List<String> compFrom, List<String> compTo) {
		List<String> nonFound = new ArrayList<String>();
		for (String compareFrom : compFrom) {
			int occ = 0;
			for (String compareTo : compTo) {
				if (compareFrom.equalsIgnoreCase(compareTo)) {
					occ++;
				}
			}
			if (occ == 0) {
				nonFound.add(compareFrom);
			}
		}
		return nonFound;
	}

}