package com.mcp.employee_mcp_server.dtos;

import com.mcp.employee_mcp_server.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CreateEmployeeRequest {


    @NotBlank
    @Schema(description = "Name of the employee")
    private String username;


    @Schema(description = "Role of the employee")
    private Roles role;
}
