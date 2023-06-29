package com.gesconge.gesconge.Repositories;
import com.gesconge.gesconge.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends JpaRepository<Employee,Long> {
    @Query(value="select id_emp from employee where username like ?1",nativeQuery=true)
    long GetIdEmp(@Param("username") String username);
}
