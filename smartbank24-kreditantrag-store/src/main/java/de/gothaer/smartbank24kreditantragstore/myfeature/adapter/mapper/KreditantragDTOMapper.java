package de.gothaer.smartbank24kreditantragstore.myfeature.adapter.mapper;


import org.mapstruct.Mapper;
import de.gothaer.smartbank24kreditantragstore.myfeature.adapter.dto.KreditantragDTO;
import de.gothaer.smartbank24kreditantragstore.myfeature.domain.aggregate.Kreditantrag;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Kreditantrag convert(KreditantragDTO kreditantrag);

    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> antraege);
}
