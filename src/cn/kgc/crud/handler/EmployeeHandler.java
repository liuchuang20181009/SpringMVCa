package cn.kgc.crud.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.kgc.crud.dao.DepartmentDao;
import cn.kgc.crud.dao.EmployeeDao;
import cn.kgc.crud.entity.Employee;

@Controller
public class EmployeeHandler {

	/*DepartmentDao deptDao=new DepartmentDao();
	EmployeeDao empDao = new EmployeeDao();*/
	
	@Autowired
	DepartmentDao deptDao;
	
	@Autowired
	EmployeeDao empDao;
	//修改相关方法
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id,Map<String,Object> map){
		map.put("departments", deptDao.getDepartments());
		map.put("genders", genders());
		map.put("employee",empDao.get(id));
		return "edit";
	}
	
	
	@ModelAttribute
	public void testUpdate(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		
		if(id !=null){
			map.put("employee", empDao.get(id));
		}
		
		
	}
	
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		empDao.save(employee);
		
		return "redirect:/emps";
	}
	
	
	
	
	
	
	
	//============删除相关方法=======
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		empDao.delete(id);
		return "redirect:/emps";
	}
	
	
	
	
	
	
	
	
	
	
	
	//=======================================
	/**
	 * 增加的相关方法
	 * @param map
	 * @return
	 */
	
	//曾加的页面
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("departments", deptDao.getDepartments());
		map.put("genders", genders());
		map.put("employee", new Employee());
		return "input";
	}
	
	public Map<String,Object> genders(){
		Map<String,Object> gender = new HashMap<>();
		gender.put("0", "男");
		gender.put("1", "女");
		
		return gender;
	}
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee){
		empDao.save(employee);
		
		return "redirect:/emps";
	}
	
	
	
	//=======================================

	//查询所有信息的方法
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String showAll(Map<String,Object> map){
		
		map.put("employees", empDao.getAll());
		return "list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
