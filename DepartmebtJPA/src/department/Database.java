/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sun watcha
 */
public class Database {

    public static void insertDepartment(Department department) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(department);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void insertEmployee(Employee employee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteDepartment(Department department) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Department fromDB = em.find(Department.class, department.getDepartmentid());
        em.getTransaction().begin();
        try {
            em.remove(fromDB);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteEmployee(Employee employee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        Employee fromDB = em.find(Employee.class, employee.getEmployeeid());
        em.getTransaction().begin();
        try {
            em.remove(fromDB);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static List<Employee> findAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> employeeList = (List<Employee>) (em.createNamedQuery("Employee.findAll").getResultList());
        Collections.sort(employeeList, Comparator.comparing(Employee::getEmployeeid));
        em.close();
        return employeeList;
    }

    public static List<Department> findAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Department> departmentList = (List<Department>) (em.createNamedQuery("Department.findAll").getResultList());
        em.close();
        return departmentList;
    }
}
