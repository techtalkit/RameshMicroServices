package net.techtalkit.employeeservice.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "OrganizationDto model information"
)
public class OrganizationDto {

    private Long id;
    @Schema(
            description = "organization name"
    )
    private String organizationName;
    @Schema(
            description = "organization description"
    )
    private String organizationDescription;
    @Schema(
            description = "organization code"
    )
    private String organizationCode;
    @Schema(
            description = "created date"
    )
    private LocalDateTime createdDate;
}
