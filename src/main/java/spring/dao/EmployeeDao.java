package spring.dao;

import spring.model.Employee;

import java.util.List;

public interface EmployeeDao extends BaseDao<Long, Employee> {

    List<Employee> findByName(String name);
}
