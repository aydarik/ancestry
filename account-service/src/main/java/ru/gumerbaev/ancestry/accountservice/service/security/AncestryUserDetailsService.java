package ru.gumerbaev.ancestry.accountservice.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gumerbaev.ancestry.accountservice.domain.AuthUser;
import ru.gumerbaev.ancestry.accountservice.repository.UserRepository;

@Service
public class AncestryUserDetailsService implements UserDetailsService {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private final UserRepository repository;

    @Autowired
    public AncestryUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username).orElse(createEmptyUser(username));
    }

    private AuthUser createEmptyUser(String username) {
        return repository.save(new AuthUser(username, ENCODER.encode("changeit")));
    }
}
