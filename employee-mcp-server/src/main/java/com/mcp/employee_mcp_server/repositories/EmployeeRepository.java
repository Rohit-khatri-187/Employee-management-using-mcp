package com.mcp.employee_mcp_server.repositories;

import com.mcp.employee_mcp_server.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findById(Long eId);

    List<Employee> getAllById(Long id);

    @Query("""
    SELECT e
    FROM Employee e
    WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))
    """)
    List<Employee> searchEmployeesByName(@Param("name") String name);
}
