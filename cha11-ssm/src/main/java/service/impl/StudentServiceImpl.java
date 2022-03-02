package service.impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.List;
import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int num = studentDao.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> searchStudents() {
        return studentDao.selectStudents();
    }
}
