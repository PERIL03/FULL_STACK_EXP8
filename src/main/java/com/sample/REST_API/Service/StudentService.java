package com.sample.REST_API.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.REST_API.Model.Student;
import com.sample.REST_API.Repository.StudentRepository;


	@Service
	public class StudentService {

		@Autowired
	    private StudentRepository repository;

	    public List<Student> getAllStudents() {
	        return repository.findAll();
	    }

	    public Student saveStudent(Student student) {
	        return repository.save(student);
	    }
	    
	    @SuppressWarnings("deprecation")
		public Student getStudentById(int id) {
	    	return repository.getById(id);
	    }
    
    public Student updateStudent(int id, Student studentDetails) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        student.setName(studentDetails.getName());
        student.setCourse(studentDetails.getCourse());
        return repository.save(student);
    }
    
    public void deleteStudent(int id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        repository.delete(student);
    }
}
