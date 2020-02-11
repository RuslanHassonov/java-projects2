package be.mobyus.rest.controller.authenticated.user;

import be.mobyus.service.ProductService;
import be.mobyus.service.UserService;
import be.mobyus.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("authenticated/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "get", method = GET, produces= "application/json")
	@ResponseBody
	public User getUser() {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userService.loadUser(userDetails.getUsername());
	}
}
