package de.gothaer.smartbank24kreditantragstore.adapter.mapper;


import org.mapstruct.Mapper;
import de.gothaer.smartbank24kreditantragstore.adapter.dto.KreditantragDTO;
import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Kreditantrag convert(KreditantragDTO kreditantrag);

    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> antraege);
}
