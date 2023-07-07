package com.gesconge.gesconge.Repositories;
import com.gesconge.gesconge.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface IEmployee extends JpaRepository<Employee,Long> {
    Optional<Employee> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
