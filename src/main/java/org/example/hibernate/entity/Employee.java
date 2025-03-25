package main.java.org.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "name", nullable = false)
    private String name;

    public Employee() {}

    public Employee(String name, Job job) {
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public Job getJobId() {
        return job;
    }

    public void setJobId(Job job) { this.job = job; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String toString() {
        return Integer.toString(id) + "; " + name + "; " + job.getName();
    }
}
