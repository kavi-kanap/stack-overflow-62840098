package com.example.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

		Employee employee = new Employee(1l, "Kav");
		Map<String, Employee> map = new HashMap<>();
		map.put("Cube1", employee);
		map.put("Cube2", employee);
		Department dep = new Department(1l, map);
		employee.setDepartment(dep);
		//Saved a department and an employee with 2 cubicles
		departmentRepository.save(dep);

		Department retrieved = departmentRepository.findById(employee.getId()).get();
		System.out.println(retrieved);
		//Output
		//Department{id=1, employeesByCubicle={Cube1=Employee{id=1, name='Kav'},
		//                                     Cube2=Employee{id=1, name='Kav'}}}
	}
}


