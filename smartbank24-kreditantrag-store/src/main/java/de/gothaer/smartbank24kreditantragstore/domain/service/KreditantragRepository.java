package de.gothaer.smartbank24kreditantragstore.domain.service;

import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;

import java.util.Optional;

public interface KreditantragRepository {

    void anlegen(Kreditantrag antrag);

    boolean existenzPruefen(Kreditantrag k);

    Optional<Kreditantrag> findeAntragNachId(String id);

    Iterable<Kreditantrag> findeAlle();
}
