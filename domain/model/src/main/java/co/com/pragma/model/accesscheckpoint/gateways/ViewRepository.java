package co.com.pragma.model.accesscheckpoint.gateways;


import co.com.pragma.model.accesscheckpoint.View;

public interface ViewRepository {
    View findByIdentifierView(String identifier);
}
