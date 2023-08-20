package net.techtalkit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "EmployeeDto model information"
)
public class EmployeeDto {
    private Long Id;
    @Schema(
            description = "employee first name"
    )
    private String firstName;
    @Schema(
            description = "employee last name"
    )
    private String lastName;
    @Schema(
            description = "employee email"
    )
    private String email;
    @Schema(
            description = "department code"
    )
    private String departmentCode;
    @Schema(
            description = "organization code"
    )
    private String organizationCode;

}
