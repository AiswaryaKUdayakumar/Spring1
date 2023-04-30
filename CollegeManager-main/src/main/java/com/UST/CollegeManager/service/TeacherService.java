package com.UST.CollegeManager.service;

import com.UST.CollegeManager.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    private TeacherRepository TeacherRepository;

    public Teacher addT(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Teacher> getFacultiesByCollegeId(Long collegeId) {
        return facultyRepository.findByCollegeId(collegeId);
    }

    public List<Faculty> getFacultiesByDepartmentId(Long departmentId) {
        return facultyRepository.findByDepartmentId(departmentId);
    }
}

