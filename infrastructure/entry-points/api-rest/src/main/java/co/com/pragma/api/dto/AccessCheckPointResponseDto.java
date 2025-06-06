package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessCheckPointResponseDto {
    @NotNull
    @Schema(example = "4f63ac55-7c3b-4d44-894d-d92851c822b3")
    private String viewIdentifier;
    @NotNull
    @Schema(example = "1234567890")
    private String userId;
    @NotNull
    @Schema(example = "192.168.224.1")
    private String ip;
}
