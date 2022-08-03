package de.gothaer.smartbank24kreditantragstore.adapter.event.eventstore.services;


import de.gothaer.smartbank24kreditantragstore.adapter.event.KreditantragEvent;
import de.gothaer.smartbank24kreditantragstore.adapter.event.ScoringEvent;

public interface EventService {

    void storeKreditantragRegistiertEvent(KreditantragEvent event);
    void storeScoringPositiveEvent(ScoringEvent event);
    void storeScoringNegativeEvent(ScoringEvent event);
    void storeCityScoringPositiveEvent(ScoringEvent event);
    void storeCityScoringNegativeEvent(ScoringEvent event);
    void storeAndFireKreditAntragPersistiertOutEvent(KreditantragEvent event);
    void storeAndFireKreditvertragEmpfohlenOutEvent(KreditantragEvent event);
    void storeAndFireKreditvertragAbgelehntOutEvent(KreditantragEvent event);
}
