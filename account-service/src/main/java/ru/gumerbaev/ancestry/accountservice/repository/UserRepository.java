package ru.gumerbaev.ancestry.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gumerbaev.ancestry.accountservice.domain.AuthUser;

@Repository
public interface UserRepository extends CrudRepository<AuthUser, String> {

}
