package com.UST.CollegeManager.controller;

import com.UST.CollegeManager.entity.Department;
import com.UST.CollegeManager.entity.Teacher;
import com.UST.CollegeManager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        Department newDepartment = departmentService.addDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long id) {
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{departmentId}/teachers")
    public ResponseEntity<Teacher> addTeacher(@PathVariable(value = "departmentId") Long departmentId,
                                              @Valid @RequestBody Teacher teacher) {
        Teacher newTeacher = departmentService.addTeacher(departmentId, teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @GetMapping("/{departmentId}/teachers")
    public ResponseEntity<List<Teacher>> getTeachersByDepartmentId(@PathVariable(value = "departmentId") Long departmentId) {
        List<Teacher> teachers = departmentService.getTeachersByDepartmentId(departmentId);
        return ResponseEntity.ok(teachers);
    }
}

