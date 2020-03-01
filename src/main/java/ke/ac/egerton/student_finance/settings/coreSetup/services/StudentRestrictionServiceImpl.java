package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.StudentRestriction;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.StudentRestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentRestrictionServiceImpl implements StudentRestrictionService {

    @Autowired
    StudentRestrictionRepository studentRestrictionRepository;

    @Override
    public StudentRestriction saveStudentRestriction(StudentRestriction studentRestriction) {
        return studentRestrictionRepository.save(studentRestriction);
    }

    @Override
    public StudentRestriction updateStudentRestriction(StudentRestriction studentRestriction) {
        return null;
    }

    @Override
    public List<StudentRestriction> getAllStudentRestriction() {
        return this.studentRestrictionRepository.findAll();
    }

    @Override
    public StudentRestriction getStudentRestrictionById(long id) {
        return this.studentRestrictionRepository.findOne(id);
    }

    @Override
    public StudentRestriction getStudentRestrictionByCode(String code) {
        return null;
    }

    @Override
    public void deleteStudentRestriction(long id) {

    }
}
