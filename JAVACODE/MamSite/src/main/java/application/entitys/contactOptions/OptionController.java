package application.entitys.contactOptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("options")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OptionController {
	
	
	@Autowired
	private OptionRep optionRep;
	
	
	@GetMapping("/getAll")
	public List<String> allOptions(){
		List<String> returner = new ArrayList<>();
		for (Options option: optionRep.findAll()) {
			returner.add(option.getOption());
		}
		return returner;	
	}
	
	

}
