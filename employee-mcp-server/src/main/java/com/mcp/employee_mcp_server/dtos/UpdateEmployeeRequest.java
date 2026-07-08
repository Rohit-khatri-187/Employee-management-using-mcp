package com.mcp.employee_mcp_server.dtos;

import com.mcp.employee_mcp_server.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    @NotNull
    @Schema(description = "Employee id")
    private Long employeeId;

    @Schema(description = "Updated employee name")
    private String username;

    @Schema(description = "Updated employee role")
    private Roles role;

}
