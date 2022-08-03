package de.gothaer.smartbank24kreditantragstore.application.service.internal;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragPersistiertLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.LocalEventPublisher;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocalEventPublisherImpl implements LocalEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void sende(KreditantragPersistiertLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(KreditAntragAcceptedLocalEvent event) {
        publisher.publishEvent(event);
    }

    @Override
    public void sende(KreditantragDeniedLocalEvent event) {
        publisher.publishEvent(event);
    }
}
