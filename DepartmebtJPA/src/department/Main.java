/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department;

import java.util.List;

/**
 *
 * @author sun watcha
 */
public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Department it = new Department(1, "IT");
        Department hr = new Department(2, "HR");

        Employee emp1 = new Employee(1, "John", "Network Admin", 56789, it);
        Employee emp2 = new Employee(2, "Marry", "HR Manager", 46789, hr);
        Employee emp3 = new Employee(3, "Henry", "Programmer", 67890, it);
        Employee emp4 = new Employee(4, "Clark", "HR Recruiter", 36789, hr);

        it.addEmployee(emp1);
        it.addEmployee(emp3);
        hr.addEmployee(emp2);
        hr.addEmployee(emp4);

        database.persist(it, hr);
        List<Employee> emps = database.findAllEmployeeByID();
        System.out.println("\nAll employee (by ID)");
        System.out.println("---------------------------");

        for (Employee emp : emps) {
            System.out.println(emp);
            System.out.println("---------------------------");
        }
        
        List<Department> depts = database.findAllEmployeeByDepartment();
        System.out.println("\nAll employee (by Department)");
        System.out.println("---------------------------");
        for (Department dept : depts) {
            System.out.println(dept);
        }
        database.removeDeptpartment(it, hr);
    }
}
