package co.com.pragma.api.controller;
import co.com.pragma.api.dto.AccessCheckPointRequestDto;
import co.com.pragma.api.dto.AccessCheckPointResponseDto;
import co.com.pragma.api.dto.ResponseErrorDto;
import co.com.pragma.api.mapper.AccessCheckPointDtoMapper;
import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;
import co.com.pragma.model.accesscheckpoint.config.ErrorCode;
import co.com.pragma.usecase.accesscheckpoint.AccessCheckPointUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.pragma.model.accesscheckpoint.config.PragmaException;

@RestController
@RequestMapping(value = "/api/access-check-point", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Ticketing", description = "Creacion de venta")
public class ApiRest {

    private HealthEndpoint healthEndpoint;
    private AccessCheckPointUseCase accessCheckPointUseCase;

    @Operation(
            summary = "Verifica el estado del servicio",
            description = "Este endpoint permite monitorear si el servicio está disponible.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "El servicio está activo"),
            }
    )
    @RequestMapping(path = "/health", method = RequestMethod.HEAD)
    public ResponseEntity<Void> health() {
        HealthComponent healthComponent = healthEndpoint.health();

        if (Status.UP.equals(healthComponent.getStatus())) {
            return ResponseEntity.ok().build();
        } else {
            throw new PragmaException(ErrorCode.SP503);
        }
    }

    @Operation(summary = "Permite hacer registro de ingreso")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AccessCheckPointResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping
    public AccessCheckPointResponseDto record(@RequestBody @Valid AccessCheckPointRequestDto accessCheckPointRequestDto) {
        AccessCheckPoint accessCheckPoint = AccessCheckPointDtoMapper.accessCheckPointDtoToAccessCheckPoint(accessCheckPointRequestDto);
        AccessCheckPoint accessCheckPointResponse = accessCheckPointUseCase.register(accessCheckPoint);
        return AccessCheckPointDtoMapper.accessCheckPointToAccessCheckPointResponseDto(accessCheckPointResponse);
    }
}
