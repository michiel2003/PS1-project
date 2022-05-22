package application.entitys.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {
	
	@Autowired
	private QuestionRep questionRep;
	
	@RequestMapping("/addQuestion")
	public void getNewQuestion(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("message") String message) {
		
		Question question = new Question(name, mail, subject, message);
		questionRep.save(question);
		
	}

}
