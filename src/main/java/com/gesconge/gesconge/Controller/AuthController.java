package com.gesconge.gesconge.Controller;

import com.gesconge.gesconge.Entities.Employee;
import com.gesconge.gesconge.Entities.Role;
import com.gesconge.gesconge.Entities.RoleName;
import com.gesconge.gesconge.Repositories.IEmployee;
import com.gesconge.gesconge.Repositories.IRole;
import com.gesconge.gesconge.Request.LoginRequest;
import com.gesconge.gesconge.Request.SignupRequest;
import com.gesconge.gesconge.Response.JwtResponse;
import com.gesconge.gesconge.Response.MessageResponse;
import com.gesconge.gesconge.Security.Service.UserDetailsImpl;
import com.gesconge.gesconge.Security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IEmployee employeeRepository;

    @Autowired
    IRole roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
        System.out.println( "*******************************"+signUpRequest.getPassword());
        if (employeeRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (employeeRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create new user's account

        Employee employee = new Employee(signUpRequest.getUsername(), signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()));
        //    System.out.println( "*******************//////////************"+user.getPassword_user());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<Role>();

        if (strRoles == null) {

            Role userRole = roleRepository.findByName(RoleName.ROLE_SALARIER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {

            strRoles.forEach(role -> {
                switch (role) {

                    case "ROLE_ADMIN":
                        System.out.println( "*********11111**********"+role);
                        Role adminRole = roleRepository.findByName(RoleName.ROLE_MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "ROLE_MODERATOR":
                        System.out.println( "*********22222**********"+role);
                        Role modRole = roleRepository.findByName(RoleName.ROLE_RH)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;

                    case "ROLE_USER":
                        System.out.println( "*********333333**********"+role);
                        Role userRole = roleRepository.findByName(RoleName.ROLE_SALARIER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        employee.setRoles(roles);
        employeeRepository.save(employee);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}


