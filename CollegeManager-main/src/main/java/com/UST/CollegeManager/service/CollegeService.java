package com.UST.CollegeManager.service;

import com.UST.CollegeManager.entity.College;

import com.UST.CollegeManager.entity.Department;
import com.UST.CollegeManager.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    public College getCollegeByName(String name) {
        return collegeRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("College", "name", name));
    }

    public College updateCollege(Long id, College college) {
        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", id));
        existingCollege.setName(college.getName());
        existingCollege.setAddress(college.getAddress());
        existingCollege.setPhone(college.getPhone());
        existingCollege.setEmail(college.getEmail());
        return collegeRepository.save(existingCollege);
    }

    public void deleteCollege(Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", id));
        collegeRepository.delete(college);
    }

    public Department addDepartment(Long collegeId, Department department) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", collegeId));
        department.setCollege(college);
        return departmentRepository.save(department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return departmentRepository.findByCollegeName(collegeName);
    }

    public Teacher addFaculty(Long collegeId, Teacher teacher) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", collegeId));
        teacher.setCollege(college);
        return facultyRepository.save(teacher);
    }

    public List<Teacher> getFacultiesByCollegeName(String collegeName) {
        return facultyRepository.findByCollegeName(collegeName);
    }
}
