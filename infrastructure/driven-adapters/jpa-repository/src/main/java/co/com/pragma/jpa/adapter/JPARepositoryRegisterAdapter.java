package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.RegisterEntity;
import co.com.pragma.jpa.mapper.RegisterMapper;
import co.com.pragma.jpa.repository.JPARegisterRepository;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;
import co.com.pragma.model.accesscheckpoint.config.ErrorCode;
import co.com.pragma.model.accesscheckpoint.config.PragmaException;
import co.com.pragma.model.accesscheckpoint.gateways.AccessCheckPointRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class JPARepositoryRegisterAdapter extends AdapterOperations<AccessCheckPoint, RegisterEntity, Long, JPARegisterRepository>
    implements AccessCheckPointRepository
{

    public JPARepositoryRegisterAdapter(JPARegisterRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, AccessCheckPoint.class));
    }

    @Override
    public AccessCheckPoint register(AccessCheckPoint accessCheckPoint) {
        RegisterEntity registerEntity = saveData(RegisterMapper.toEntity(accessCheckPoint));
        if(Objects.isNull(registerEntity)){
            throw new PragmaException(ErrorCode.B409014);
        }
        return RegisterMapper.toDomain(registerEntity);
    }
}
