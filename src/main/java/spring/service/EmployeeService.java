package spring.service;

import spring.dao.EmployeeDao;
import spring.model.Company;
import spring.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Gender;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Transactional
    public Long save(Employee employee) {

     //   Employee.of("Ivan5", Gender.MALE, Company.of("Google",), , )
        return employeeDao.save(employee);
    }

    @Transactional
    public Optional<Employee> findById(Long id) {
        Optional<Employee> employee = employeeDao.find(id);
        return employee;
    }
}
