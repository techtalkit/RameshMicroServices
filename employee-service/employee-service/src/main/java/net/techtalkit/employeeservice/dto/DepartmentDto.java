package net.techtalkit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "DepartmentDto model information"
)
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department name"
    )
    private String departmentName;
    @Schema(
            description = "Department description"
    )
    private String departmentDescription;
    @Schema(
            description = "Department code"
    )
    private String departmentCode;
}
