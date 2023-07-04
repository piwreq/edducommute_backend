package be.devrise.educommute.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolService {

    private final SchoolRepository schoolRepo;

    @Autowired
    public SchoolService (SchoolRepository schoolRepo){this.schoolRepo = schoolRepo;}

    public List<School> getAllSchool(){
        return schoolRepo.findAll();
    }

}
