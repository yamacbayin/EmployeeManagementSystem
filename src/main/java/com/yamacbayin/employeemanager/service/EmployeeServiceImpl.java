package com.yamacbayin.employeemanager.service;

import com.yamacbayin.employeemanager.dao.EmployeeRepository;
import com.yamacbayin.employeemanager.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
