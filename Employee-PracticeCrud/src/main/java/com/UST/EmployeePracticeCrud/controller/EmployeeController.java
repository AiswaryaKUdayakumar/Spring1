package com.UST.EmployeePracticeCrud.controller;

import com.UST.EmployeePracticeCrud.entity.EmployeeEntity;
import com.UST.EmployeePracticeCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService services;
    @PostMapping("/emp1")
    public EmployeeEntity post(@RequestBody EmployeeEntity empent){
        return services.postStud(empent);
    }
    @GetMapping("/emp2")
    public List<EmployeeEntity> get(){
        return services.getAll();
    }
    @GetMapping("/emp3/{id}")
    public EmployeeEntity getemp(@PathVariable Long id){
        return services.getById(id);
    }
    @PutMapping("/emp4/{id}")
    public EmployeeEntity update(@RequestBody EmployeeEntity empent){
        return services.updateById(empent);
    }
    @DeleteMapping("/emp5/{id}")
    public String delete(@PathVariable Long id){
        return services.deleteById(id);

    }


}