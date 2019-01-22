package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.Employee;
import spring.service.EmployeeService;

import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeService employeeService =(EmployeeService) context.getBean("employeeService");

        Optional<Employee> byId = employeeService.findById(1L);
        System.out.println(byId);

        System.out.println();
    }
}
