package spring.dao;

import org.hibernate.Session;
import spring.model.Employee;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Long, Employee> implements EmployeeDao {

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> firstName = getSessionFactory().openSession().
                createQuery("select e from Employee e where e.name = :firstName", Employee.class)
                .setParameter("firstName", name).list();
        return firstName;
    }
}
