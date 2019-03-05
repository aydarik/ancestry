package ru.gumerbaev.ancestry.accountservice.service;

import ru.gumerbaev.ancestry.accountservice.domain.AuthUser;

public interface UserService {

	void create(AuthUser user);

	void delete(String username);
}
