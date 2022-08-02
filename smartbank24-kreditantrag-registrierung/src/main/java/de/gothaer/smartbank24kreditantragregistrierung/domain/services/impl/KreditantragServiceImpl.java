package de.gothaer.smartbank24kreditantragregistrierung.domain.services.impl;


import de.gothaer.smartbank24kreditantragregistrierung.domain.KreditantragRepository;
import de.gothaer.smartbank24kreditantragregistrierung.domain.model.Kreditantrag;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.gothaer.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class KreditantragServiceImpl implements KreditantragService {

    private final KreditantragRepository repo;

    @Override
    public void register(Kreditantrag kreditantrag) throws KreditantragServiceException {
        if(repo.existenzPruefen(kreditantrag)) {
            throw new KreditantragServiceException("Upps");
        }
        repo.anlegen(kreditantrag);

    }

    @Override
    public Optional<Kreditantrag> findById(String id) throws KreditantragServiceException {
        return repo.findeAntragNachId(id);
    }

    @Override
    public Iterable<Kreditantrag> findAll() throws KreditantragServiceException {
        return repo.findeAlle();
    }
}
