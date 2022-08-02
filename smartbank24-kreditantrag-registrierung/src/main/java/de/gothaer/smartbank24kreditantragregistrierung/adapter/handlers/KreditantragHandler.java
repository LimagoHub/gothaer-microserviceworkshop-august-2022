package de.gothaer.smartbank24kreditantragregistrierung.adapter.handlers;


import de.gothaer.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;

public interface KreditantragHandler {
    void handle(KreditantragDTO kreditantragDTO) throws KreditantragServiceException;
}
