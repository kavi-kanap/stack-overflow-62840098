package com.example.map;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Department {
    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
    @MapKeyColumn(name="CUB_ID", nullable = true)
    private Map<String, Employee> employeesByCubicle;

    public Department() {
    }

    public Department(Long id, Map<String, Employee> employeesByCubicle) {
        this.id = id;
        this.employeesByCubicle = employeesByCubicle;
    }

    public Long getId() {
        return id;
    }

    public Map<String, Employee> getEmployeesByCubicle() {
        return employeesByCubicle;
    }

    public void setEmployeesByCubicle(Map<String, Employee> employeesByCubicle) {
        this.employeesByCubicle = employeesByCubicle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", employeesByCubicle=" + employeesByCubicle +
                '}';
    }
}
