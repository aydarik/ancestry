package ru.gumerbaev.ancestry.accountservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gumerbaev.ancestry.accountservice.domain.AuthUser;
import ru.gumerbaev.ancestry.accountservice.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AuthUser user) {
        Optional<AuthUser> existing = repository.findById(user.getUsername());
        existing.ifPresent(it -> {
            throw new IllegalArgumentException("User already exists: " + it.getUsername());
        });

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);

        log.info("New user has been created: {}", user.getUsername());
    }

    @Override
    public void delete(String username) {
        Optional<AuthUser> existing = repository.findById(username);
        repository.delete(existing.orElseThrow());

        log.info("User has been deleted: {}", username);
    }
}
