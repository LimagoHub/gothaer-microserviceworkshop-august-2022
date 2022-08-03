package de.gothaer.smartbank24kreditantragstore.domain.service;

import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;
import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Statuswechsel;

public interface KreditantragService {


    void speichereOderAendereKreditantrag(Kreditantrag antrag) throws KreditantragServiceException;
    void verarbeitePositivesScoring(String id) throws KreditantragServiceException;
    void verarbeitePositivesCityScoring(String id) throws KreditantragServiceException;
    void verarbeiteNegativesScoring(String id) throws KreditantragServiceException;
    void verarbeiteNegativesCityScoring(String id) throws KreditantragServiceException;
    Kreditantrag findeKreditantragMitId(String id) throws KreditantragServiceException;
}
