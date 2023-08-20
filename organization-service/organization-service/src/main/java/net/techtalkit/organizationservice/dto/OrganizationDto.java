package net.techtalkit.organizationservice.dto;
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
            description = "Organization name"
    )
    private String organizationName;
    @Schema(
            description = "Organization description"
    )
    private String organizationDescription;
    @Schema(
            description = "Organization code"
    )
    private String organizationCode;
    @Schema(
            description = "Created date"
    )
    private LocalDateTime createdDate;
}
