package ru.gumerbaev.ancestry.accountservice.service;

import ru.gumerbaev.ancestry.accountservice.domain.User;

public interface UserService {

	void create(User user);

	void delete(String username);
}
