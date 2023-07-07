package com.gesconge.gesconge.Security.Service;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Repositories.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IEmployee employeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      /*  Employee user = employeeRepository.findByUsername(username).get();
        if (user == null) {
            throw new UsernameNotFoundException("userName" + username + "Not found in the database");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), getGrantedAuth(user));

*/


        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(employee);
    }

}