package de.gothaer.smartbank24kreditantragstore.domain.event;

import de.gothaer.smartbank24kreditantragstore.domain.aggregate.Kreditantrag;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KreditAntragAcceptedLocalEvent {

    private Kreditantrag kreditantrag;
}
