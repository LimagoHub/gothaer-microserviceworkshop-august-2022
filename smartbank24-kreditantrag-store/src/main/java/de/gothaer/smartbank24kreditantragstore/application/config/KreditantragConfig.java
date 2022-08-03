package de.gothaer.smartbank24kreditantragstore.application.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import de.gothaer.smartbank24kreditantragstore.domain.event.LocalEventPublisher;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragRepository;
import de.gothaer.smartbank24kreditantragstore.domain.service.KreditantragService;
import de.gothaer.smartbank24kreditantragstore.domain.service.internal.KreditantragServiceImpl;

@Configuration
public class KreditantragConfig {

    @Bean
    public KreditantragService createKreditantragService(KreditantragRepository repo, LocalEventPublisher publisher) {
        return new KreditantragServiceImpl(repo, publisher);
    }
}
