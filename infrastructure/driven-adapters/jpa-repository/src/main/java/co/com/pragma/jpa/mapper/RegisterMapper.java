package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.RegisterEntity;
import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;

public class RegisterMapper {

    public static RegisterEntity toEntity(AccessCheckPoint accessCheckPoint){
        return RegisterEntity.builder()
                .viewIdentifier(accessCheckPoint.getViewIdentifier())
                .userId(accessCheckPoint.getUserId())
                .ip(accessCheckPoint.getIp())
                .build();
    }

    public static AccessCheckPoint toDomain(RegisterEntity registerEntity){
        return AccessCheckPoint.builder()
                .viewIdentifier(registerEntity.getViewIdentifier())
                .userId(registerEntity.getUserId())
                .ip(registerEntity.getIp())
                .build();
    }
}
