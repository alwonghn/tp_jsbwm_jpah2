package demo.service;

import demo.model.Student;
import demo.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
	//log.info("into StudentService implementation. findAll class");
        List<Student> students = (List<Student>) repository.findAll();
        return students;
    }
}
