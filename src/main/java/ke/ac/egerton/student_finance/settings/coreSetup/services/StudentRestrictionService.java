package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.StudentRestriction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentRestrictionService {
    StudentRestriction saveStudentRestriction(StudentRestriction studentRestriction);

    StudentRestriction updateStudentRestriction(StudentRestriction studentRestriction);

    List< StudentRestriction > getAllStudentRestriction();

    StudentRestriction getStudentRestrictionById(long id);

    StudentRestriction getStudentRestrictionByCode(String code);

    void deleteStudentRestriction(long id);
}
