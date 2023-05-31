package Services;

import com.gesconge.gesconge.Entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    void deleteEmployee(Employee emp);
    Employee getEmployeeById(long idemp);
    List<Employee>getAlEmployee();



}