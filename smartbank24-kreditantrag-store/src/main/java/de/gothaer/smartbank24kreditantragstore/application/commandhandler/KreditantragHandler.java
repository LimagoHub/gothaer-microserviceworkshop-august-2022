package de.gothaer.smartbank24kreditantragstore.application.commandhandler;


import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragServiceException;

public interface KreditantragHandler {
    void handleKreditantragRegistriert(Kreditantrag kreditantrag);
    void handleScoringPositiv(String id);
    void handleScoringNegativ(String id);
    void handleCityScoringPositiv(String id);
    void handleCityScoringNegativ(String id);
}
