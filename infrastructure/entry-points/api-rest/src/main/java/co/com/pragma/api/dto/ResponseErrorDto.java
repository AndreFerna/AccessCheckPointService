package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.wildfly.common.annotation.NotNull;

@Getter
@Builder
public class ResponseErrorDto {
    @NotNull
    @Schema(example = "4XX-XXX")
    private String code;
    @NotNull
    @Schema(example = "Mensaje de la excepcion")
    private String message;
}
