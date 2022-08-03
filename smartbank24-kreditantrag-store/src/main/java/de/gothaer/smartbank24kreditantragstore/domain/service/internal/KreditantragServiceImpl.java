package de.gothaer.smartbank24kreditantragstore.domain.service.internal;

import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;
import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Statuswechsel;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragPersistiertLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.LocalEventPublisher;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragRepository;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragService;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragServiceException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KreditantragServiceImpl implements KreditantragService {


    private final KreditantragRepository repo;
    private final LocalEventPublisher publisher;

    @Override
    public void speichereKreditantrag(Kreditantrag antrag) throws KreditantragServiceException {
        try {
            this.speichereOderAendereKreditantrag(antrag);
            publisher.sende(KreditantragPersistiertLocalEvent.builder().kreditantrag(antrag).build());
        } catch (RuntimeException e) {
            throw new KreditantragServiceException(e);
        }
    }

    private void speichereOderAendereKreditantrag(Kreditantrag antrag) throws KreditantragServiceException {
        try {
            repo.anlegen(antrag);
        } catch (RuntimeException e) {
            throw new KreditantragServiceException(e);
        }
    }

    @Override
    public void verarbeitePositivesScoring(String id) throws KreditantragServiceException {
        Kreditantrag antrag = findeKreditantragMitId(id);
        final Statuswechsel statuswechsel = antrag.behandlePositivesScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == Statuswechsel.FINAL) {
            publisher.sende(KreditAntragAcceptedLocalEvent.builder().kreditantrag(antrag).build());
        }
    }

    @Override
    public void verarbeitePositivesCityScoring(String id) throws KreditantragServiceException {
        Kreditantrag antrag = findeKreditantragMitId(id);
        final Statuswechsel statuswechsel = antrag.behandlePositivesCityScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == Statuswechsel.FINAL) {
            publisher.sende(KreditAntragAcceptedLocalEvent.builder().kreditantrag(antrag).build());
        }
    }

    @Override
    public void verarbeiteNegativesScoring(String id) throws KreditantragServiceException {
        Kreditantrag antrag = findeKreditantragMitId(id);
        final Statuswechsel statuswechsel = antrag.behandleNegativesScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == Statuswechsel.FINAL) {
            publisher.sende(KreditantragDeniedLocalEvent.builder().kreditantrag(antrag).build());
        }
    }

    @Override
    public void verarbeiteNegativesCityScoring(String id) throws KreditantragServiceException {
        Kreditantrag antrag = findeKreditantragMitId(id);
        final Statuswechsel statuswechsel = antrag.behandleNegativesCityScoring();
        speichereOderAendereKreditantrag(antrag);
        if(statuswechsel == Statuswechsel.FINAL) {
            publisher.sende(KreditantragDeniedLocalEvent.builder().kreditantrag(antrag).build());
        }
    }

    @Override
    public Kreditantrag findeKreditantragMitId(String id) throws KreditantragServiceException {
        return repo.findeAntragNachId(id).orElseThrow(()->new KreditantragServiceException("Häh?"));
    }
}
