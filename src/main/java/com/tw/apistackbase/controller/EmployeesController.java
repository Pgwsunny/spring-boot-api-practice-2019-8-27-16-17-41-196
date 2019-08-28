package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employees;
import com.tw.apistackbase.utils.PAGE;
@RestController
@RequestMapping("/employees")
public class EmployeesController {
	private static Employees employees1 = new Employees(1, "name1", 0);
	private static Employees employees2 = new Employees(2, "name2", 1);
	private static Employees employees3 = new Employees(3, "name3", 0);
	private static Employees employees4 = new Employees(4, "name4", 1);

	private static List<Employees> employeesList = new ArrayList<Employees>() {{
		add(employees1);
		add(employees2);
		add(employees3);
		add(employees4);
	}};
	
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> getEmployeesList() {
//    	List<Employees> resutList;
//    	if(page != 0 && pageSize != 0) {
//    		resutList = PAGE.getPageList(page, pageSize, employeesList);
//    	}else {
//    		resutList = employeesList;
//    	}
        return ResponseEntity.ok(employeesList);
    }
	
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Employees> getEmployees(@PathVariable int id) {
    	
        return ResponseEntity.ok(employeesList.get(id));
    }
	
	@RequestMapping(value = "/getBySex",method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> getEmployees(@RequestParam(value = "gender",required = true) String gender) {
    	//1 男 2女
    	int sex = 0;
    	if("male".equals(gender)) {
    		sex = 1;
    	}
    	List resutList = new ArrayList();
    	for(Employees tmpEmployees : employeesList) {
    		if(tmpEmployees.getSex() == 1) {
    			resutList.add(tmpEmployees);
    		}
    	}
        return ResponseEntity.ok(resutList);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createEmployees(@RequestBody Employees employees ){
    	employeesList.add(employees);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity updateEmployees(@RequestBody Employees employees ,@PathVariable int id){
    	employeesList.set(id,employees);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployees(@PathVariable int id){
    	employeesList.remove(id);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value="/getPageList",method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> getPages(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "pageSize",required = true) int pageSize) {
    	
    	return ResponseEntity.ok(PAGE.getPageList(page, pageSize, employeesList));
    }
    
}
