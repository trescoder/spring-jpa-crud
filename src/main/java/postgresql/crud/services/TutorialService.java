package postgresql.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import postgresql.crud.models.Tutorial;
import postgresql.crud.repositories.TutorialRepository;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    @Transactional
    public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial){
        try {
            Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
