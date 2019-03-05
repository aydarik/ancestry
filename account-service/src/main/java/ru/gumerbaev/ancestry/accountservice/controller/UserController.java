package ru.gumerbaev.ancestry.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gumerbaev.ancestry.accountservice.domain.AuthUser;
import ru.gumerbaev.ancestry.accountservice.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		return principal;
	}

	@PreAuthorize("#oauth2.hasScope('ui')")
//	@PreAuthorize("hasRole('ROLE_ANONYMOUS')")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody AuthUser user) {
		userService.create(user);
	}

	@RequestMapping(value = "/current", method = RequestMethod.DELETE)
	public void deleteUser(Principal principal) {
		userService.delete(principal.getName());
	}
}
