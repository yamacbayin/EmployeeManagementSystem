package com.yamacbayin.employeemanager.dao;

import com.yamacbayin.employeemanager.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void deleteById(int id);

}
