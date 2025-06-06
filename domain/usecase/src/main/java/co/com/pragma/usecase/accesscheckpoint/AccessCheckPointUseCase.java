package co.com.pragma.usecase.accesscheckpoint;

import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;
import co.com.pragma.model.accesscheckpoint.config.ErrorCode;
import co.com.pragma.model.accesscheckpoint.config.PragmaException;
import co.com.pragma.model.accesscheckpoint.gateways.AccessCheckPointRepository;
import co.com.pragma.model.accesscheckpoint.gateways.UserRepository;
import co.com.pragma.model.accesscheckpoint.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class AccessCheckPointUseCase {

    private final UserRepository userRepository;
    private final ViewRepository viewRepository;
    private final AccessCheckPointRepository accessCheckPointRepository;

    public AccessCheckPoint register(AccessCheckPoint accessCheckPoint){
        validateExistsUser(accessCheckPoint.getUserId());
        validiateExistsView(accessCheckPoint.getViewIdentifier());
        return accessCheckPointRepository.register(accessCheckPoint);
    }

    public void validiateExistsView(String identifier){
        viewRepository.findByIdentifierView(identifier);
    }

    private void validateExistsUser(String organizerId) {
        boolean userExists = userRepository.exitsById(organizerId);
        if (!userExists) {
            throw new PragmaException(ErrorCode.B409007);
        }
    }

}
