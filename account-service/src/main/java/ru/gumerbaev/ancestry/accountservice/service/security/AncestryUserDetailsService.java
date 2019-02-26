package ru.gumerbaev.ancestry.accountservice.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gumerbaev.ancestry.accountservice.repository.UserRepository;

@Service
public class AncestryUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public AncestryUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
