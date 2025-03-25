package main.java.org.example;

import main.java.org.example.hibernate.dao.EmployeeDao;
import main.java.org.example.hibernate.dao.JobDao;
import main.java.org.example.hibernate.entity.Employee;
import main.java.org.example.hibernate.entity.Job;

public class Main {
    public static void main(String[] args) {
        JobDao jobDao = new JobDao();
        EmployeeDao employeeDao = new EmployeeDao();

        Job job1 = new Job("Официант");
        Job job2 = new Job("Таксист");
        jobDao.saveJob(job1);
        jobDao.saveJob(job2);

        jobDao.getAllJobs().forEach(System.out::println);

        Employee employee1 = new Employee("Иван", job1);
        Employee employee2 = new Employee("Олег", job2);
        Employee employee3 = new Employee("Ира", job1);
        employeeDao.saveEmployee(employee1);
        employeeDao.saveEmployee(employee2);
        employeeDao.saveEmployee(employee3);

        employeeDao.getAllEmployees().forEach(System.out::println);

        job1 = jobDao.getJobById(1);
        job1.setName("Курьер");
        jobDao.updateJob(job1);

        jobDao.getAllJobs().forEach(System.out::println);

        employee1 = employeeDao.getEmployeeById(1);
        employee1.setName("Миша");
        employeeDao.updateEmployee(employee1);

        employeeDao.getAllEmployees().forEach(System.out::println);

        employee1 = employeeDao.getEmployeeById(2);
        employeeDao.deleteEmployee(employee1);

        job1 = jobDao.getJobById(2);
        jobDao.deleteJob(job1);

        jobDao.getAllJobs().forEach(System.out::println);
        employeeDao.getAllEmployees().forEach(System.out::println);
    }
}