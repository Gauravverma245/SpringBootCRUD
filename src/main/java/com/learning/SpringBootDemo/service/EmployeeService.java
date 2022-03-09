package com.learning.SpringBootDemo.service;


import com.learning.SpringBootDemo.ResouceNotFoundException;
import com.learning.SpringBootDemo.model.Employee;
import com.learning.SpringBootDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("Employee Not Found By Id"));
    }

    public boolean saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return false;
        }else{
            employeeRepository.save(employee);
            return true;
        }
    }


}
