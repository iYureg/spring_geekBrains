package ru.gb.example2_sem7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.example2_sem7.entitys.User;
import ru.gb.example2_sem7.model.CustomUserDetails;
import ru.gb.example2_sem7.repositories.UserRepository;

import java.util.function.Supplier;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> msg =
                () -> new UsernameNotFoundException("User not found: " + username);

        User user = userRepository.findUserByUsername(username).orElseThrow(msg);

        return new CustomUserDetails(user);
    }
}

