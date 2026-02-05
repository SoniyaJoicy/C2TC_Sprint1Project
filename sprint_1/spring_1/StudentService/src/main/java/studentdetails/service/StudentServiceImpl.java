package studentdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import studentdetails.entity.Student;
import studentdetails.repository.StudentRepository;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ✅ SAVE STUDENT
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // ✅ GET ALL STUDENTS
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ✅ GET STUDENT BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // ✅ UPDATE STUDENT
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = getStudentById(id);

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDepartment(updatedStudent.getDepartment());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setPlacementStatus(updatedStudent.getPlacementStatus());

        return studentRepository.save(existingStudent);
    }

    // ✅ DELETE STUDENT
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}