package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.AccessCheckPointRequestDto;
import co.com.pragma.api.dto.AccessCheckPointResponseDto;
import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;

public class AccessCheckPointDtoMapper {

    public static AccessCheckPoint accessCheckPointDtoToAccessCheckPoint(AccessCheckPointRequestDto accessCheckPointRequestDto){
        return AccessCheckPoint.builder()
                .viewIdentifier(accessCheckPointRequestDto.getViewIdentifier())
                .userId(accessCheckPointRequestDto.getUserId())
                .ip(accessCheckPointRequestDto.getIp())
                .build();
    }

    public static AccessCheckPointResponseDto accessCheckPointToAccessCheckPointResponseDto(AccessCheckPoint accessCheckPoint){
        return AccessCheckPointResponseDto.builder()
                .viewIdentifier(accessCheckPoint.getViewIdentifier())
                .userId(accessCheckPoint.getUserId())
                .ip(accessCheckPoint.getIp())
                .build();
    }

}
