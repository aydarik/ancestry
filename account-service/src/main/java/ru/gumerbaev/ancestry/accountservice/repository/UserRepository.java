package ru.gumerbaev.ancestry.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gumerbaev.ancestry.accountservice.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
