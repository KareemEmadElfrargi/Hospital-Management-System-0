package com.kareem.Hospital_Management_System.Service;

import com.kareem.Hospital_Management_System.Entity.User;
import com.kareem.Hospital_Management_System.Repository.UserRepository;
import com.kareem.Hospital_Management_System.Security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String nationalId) throws UsernameNotFoundException {
        User user = userRepo.findByNationalId(nationalId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }

}