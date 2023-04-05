package com.yamacbayin.employeemanager.service;

import com.yamacbayin.employeemanager.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void deleteById(int id);
}
