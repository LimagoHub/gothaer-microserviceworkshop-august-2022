package de.gothaer.smartbank24kreditantragstore.adapter.mapper;

import org.mapstruct.Mapper;
import de.gothaer.smartbank24kreditantragstore.adapter.event.KreditantragEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragPersistiertLocalEvent;


@Mapper(componentModel = "spring")
public interface KreditantragLocalEventToDomainEventMapper {

    KreditantragEvent convert(KreditantragPersistiertLocalEvent kreditantragPersistiertLocalEvent);
    KreditantragEvent convert(KreditAntragAcceptedLocalEvent kreditAntragAcceptedLocalEvent);
    KreditantragEvent convert(KreditantragDeniedLocalEvent kreditantragDeniedLocalEvent);
}
