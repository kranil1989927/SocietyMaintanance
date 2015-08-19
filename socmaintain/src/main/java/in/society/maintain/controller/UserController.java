package in.society.maintain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.UserDAOImpl;
import in.society.maintain.model.User;
import in.society.maintain.service.UserDetailService;
import in.society.maintain.service.UserDetailsVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserControllerHelper userControllerHelper;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addUser(@RequestParam("username") String user,@RequestParam("password") String password) {
		String userName= null;
		
		UserDetailsFormBean userDetailsFormBean = new UserDetailsFormBean();
		userDetailsFormBean.setUserName(user);
		userDetailsFormBean.setPassword(password);
		try {
			UserDetailsVO userDetailsVO = userControllerHelper.populateUserDetailsVO(userDetailsFormBean);
			userName = userDetailService.addUser(userDetailsVO);
			System.out.println("User ADDED Sucessfuly : " + userName);
		} catch (SocietyMaintenanceException e) {
			System.out.println("User ADDED Sucessfuly" +  e.getMessage());
		}
		return userName;
	}
	
	@RequestMapping(value="/addUser", method = RequestMethod.GET)
	public String addUsers(Model model) {
		return "adduser";
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public String updateUser(Model model) {
		return null;
	}
	@RequestMapping(value="/getUser",method = RequestMethod.GET)
	public String getUser(Model model) {
		return null;
	}
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String deleteUser(Model model) {
		return null;
	}
	@RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		return null;
	}
}
