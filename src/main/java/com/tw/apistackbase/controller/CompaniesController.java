package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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
@RequestMapping("/companies")
public class CompaniesController {
	private static Employees employees1 = new Employees(1, "name1", 0);
	private static Employees employees2 = new Employees(2, "name2", 1);
	private static Employees employees3 = new Employees(3, "name3", 0);
	private static Employees employees4 = new Employees(4, "name4", 1);

	private static List<Employees> employee1List = new ArrayList<Employees>() {{
		add(employees1);
		add(employees2);
	}};
	
	private static List<Employees> employee2List = new ArrayList<Employees>() {{
		add(employees3);
	}};
	
	private static List<Employees> employee3List = new ArrayList<Employees>() {{
		add(employees4);
	}};
	
	private static List<Company> companyList = new ArrayList<Company>() {{
		add(new Company(0,"XIAOMI","111", employee1List));
		add(new Company(1,"GOOGLE","222", employee2List));
		add(new Company(2,"MS","333", employee3List));
	}};
	
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getCompanyList() {

        return ResponseEntity.ok(companyList);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Company> getCompany(@PathVariable int id) {
    	
        return ResponseEntity.ok(companyList.get(id));
    }
    
    @RequestMapping(value = "/{id}/employees",method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getCompanyEmployees(@PathVariable int id) {
    	companyList.get(id).getEmployeeList();
    	return ResponseEntity.ok(companyList.get(id).getEmployeeList());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCompany(@RequestBody Company company ){
    	companyList.add(company);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT,consumes = "application/json")
    public ResponseEntity updateCompany(@RequestBody Company company ,@PathVariable int id){
    	companyList.set(id, company);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteCompany(@PathVariable int id){
    	companyList.remove(id);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value="/getPageList" ,method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getPages(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "pageSize",required = true) int pageSize) {
    	
    	return ResponseEntity.ok(PAGE.getPageList(page, pageSize, companyList));
    }
    
}
