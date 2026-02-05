package studentdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import studentdetails.entity.Student;
import studentdetails.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    public Student updateStudent(Long id, Student newStudent) {

        Student existing = getStudentById(id);

        existing.setName(newStudent.getName());
        existing.setEmail(newStudent.getEmail());
        existing.setDepartment(newStudent.getDepartment());

        existing.setPhone(newStudent.getPhone());
        existing.setPlacementStatus(newStudent.getPlacementStatus());

        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}