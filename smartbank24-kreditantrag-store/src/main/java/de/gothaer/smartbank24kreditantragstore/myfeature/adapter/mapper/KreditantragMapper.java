package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.mapper;


import org.mapstruct.Mapper;
import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.repositories.entities.KreditantragEntity;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;

@Mapper(componentModel = "spring")
public interface KreditantragMapper {
    Kreditantrag convert(KreditantragEntity kreditantrag);
    KreditantragEntity convert(Kreditantrag kreditantrag);

    Iterable<Kreditantrag> convert(Iterable<KreditantragEntity> antraege);
}
