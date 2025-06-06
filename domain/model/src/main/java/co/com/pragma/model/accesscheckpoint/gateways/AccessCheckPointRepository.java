package co.com.pragma.model.accesscheckpoint.gateways;

import co.com.pragma.model.accesscheckpoint.AccessCheckPoint;

public interface AccessCheckPointRepository {
    AccessCheckPoint register(AccessCheckPoint accessCheckPoint);
}
