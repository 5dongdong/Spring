package com.example.userdetailsanduserdetailsservicesecutiry.config;

import com.example.userdetailsanduserdetailsservicesecutiry.enttiy.SecurityEntity;
import com.example.userdetailsanduserdetailsservicesecutiry.repository.SecurityEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component @RequiredArgsConstructor @Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SecurityEntityRepository securityEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityEntity securityEntity = securityEntityRepository.findByUsername("revi1337")
                .orElseThrow(() -> new UsernameNotFoundException("User Cannot Found in Database" + username));

        log.info("Success find Member {}", securityEntity);

        return User
                .withUsername(securityEntity.getId().toString())
                .password("{noop}" + securityEntity.getPassword())
                .roles("USER")
                .build();
    }
}
