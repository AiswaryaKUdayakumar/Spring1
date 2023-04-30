package com.UST.EmployeePracticeCrud.service;

import com.UST.EmployeePracticeCrud.entity.EmployeeEntity;
import com.UST.EmployeePracticeCrud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    public EmployeeEntity postStud(EmployeeEntity empent) {
        return repo.save(empent);
    }

    public List<EmployeeEntity> getAll() {
        return repo.findAll();
    }

    public EmployeeEntity getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public EmployeeEntity updateById(EmployeeEntity empent) {
        // TODO Auto-generated method stub
        EmployeeEntity oldemp = null;
        Optional<EmployeeEntity> optionalemployee = repo.findById(empent.getId());
        if (optionalemployee.isPresent()) {
            oldemp = optionalemployee.get();
            oldemp.setName(empent.getName());
            //oldemp.setAddress(employee.getAddress());
            //oldemp.setLocation(employee.getLocation());
            repo.save(oldemp);
        } else {
            return new EmployeeEntity();
        }
        return oldemp;
    }

    public String deleteById(Long id) {
        repo.deleteById(id);
        return "deleted..";
    }
}
