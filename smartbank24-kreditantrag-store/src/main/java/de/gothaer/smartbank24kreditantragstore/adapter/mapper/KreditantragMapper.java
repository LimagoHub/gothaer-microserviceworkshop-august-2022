package de.gothaer.smartbank24kreditantragstore.adapter.mapper;


import org.mapstruct.Mapper;
import de.gothaer.smartbank24kreditantragstore.adapter.repositories.entities.KreditantragEntity;
import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;

@Mapper(componentModel = "spring")
public interface KreditantragMapper {
    Kreditantrag convert(KreditantragEntity kreditantrag);
    KreditantragEntity convert(Kreditantrag kreditantrag);

    Iterable<Kreditantrag> convert(Iterable<KreditantragEntity> antraege);
}
