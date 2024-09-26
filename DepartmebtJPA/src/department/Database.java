/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package department;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sun watcha
 */
public class Database {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Database() {
    }

    public void persist(Object... objects) {
        this.emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        this.em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for (Object object : objects) {
                em.persist(object);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void removeDeptpartment(Department... depts) {
        this.emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        this.em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for (Department dept : depts) {
                Department fromDB = em.find(Department.class, dept.getDepartmentid());
//                System.out.println(fromDB);
                em.remove(fromDB);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Employee> findAllEmployeeByID() {
        this.emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        this.em = emf.createEntityManager();

        String jpql = "SELECT emp FROM Employee emp ORDER BY emp.employeeid";
        Query query = em.createQuery(jpql);

        List<Employee> empList = (List<Employee>) query.getResultList();
        em.close();
        return empList;
    }

    public List<Department> findAllEmployeeByDepartment() {
        this.emf = Persistence.createEntityManagerFactory("DepartmentJPAPU");
        this.em = emf.createEntityManager();

        String jpql = "SELECT d FROM Department d ORDER BY d.departmentid";
        Query query = em.createQuery(jpql);
        List<Department> deptList = query.getResultList();
        em.close();
        return deptList;
    }

}
