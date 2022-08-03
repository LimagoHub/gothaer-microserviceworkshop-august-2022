package de.gothaer.smartbank24kreditantragstore.adapter.event.listener;


import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import de.gothaer.smartbank24kreditantragstore.adapter.event.KreditantragEvent;
import de.gothaer.smartbank24kreditantragstore.adapter.event.ScoringEvent;
import de.gothaer.smartbank24kreditantragstore.adapter.mapper.KreditantragDTOMapper;
import de.gothaer.smartbank24kreditantragstore.application.commandhandler.KreditantragHandler;

@Configuration
public class EventListener {

    @Bean
    public Consumer<KreditantragEvent> kreditantragregistriert(final KreditantragHandler handler, final
            KreditantragDTOMapper mapper){
        return event -> handler.handleKreditantragRegistriert(mapper.convert(event.getKreditantrag()));
    }


    @Bean
    public Consumer<ScoringEvent> scoringnegative (final KreditantragHandler handler){
        return event -> handler.handleScoringNegativ(event.getCreditApplicationId());
    }
    @Bean
    public Consumer<ScoringEvent> scoringpositive (final KreditantragHandler handler){
        return event -> handler.handleScoringPositiv(event.getCreditApplicationId());
    }
    @Bean
    public Consumer<ScoringEvent> cityscoringnegative (final KreditantragHandler handler){
        return event -> handler.handleCityScoringNegativ(event.getCreditApplicationId());
    }
    @Bean
    public Consumer<ScoringEvent> cityscoringpositive (final KreditantragHandler handler){
        return event -> handler.handleCityScoringPositiv(event.getCreditApplicationId());
    }

}
