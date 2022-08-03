package de.gothaer.smartbank24kreditantragstore.adapter.event.emitter;


import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import de.gothaer.smartbank24kreditantragstore.adapter.mapper.KreditantragLocalEventToDomainEventMapper;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditAntragAcceptedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragDeniedLocalEvent;
import de.gothaer.smartbank24kreditantragstore.domain.event.KreditantragPersistiertLocalEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDING_NAME_PERSISTIERT = "kreditantragPersistiert-out-0";
    private static final String SUPPLIER_BINDING_NAME_EMPFOHLEN = "kreditvertragEmpfohlen-out-0";
    private static final String SUPPLIER_BINDING_NAME_ABGELEHNT = "kreditvertragAbgelehnt-out-0";
    private final StreamBridge bridge;
    private final KreditantragLocalEventToDomainEventMapper mapper;

    @EventListener
    public void handle(KreditantragPersistiertLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_PERSISTIERT, mapper.convert(event));
    }
    @EventListener
    public void handle(KreditAntragAcceptedLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_EMPFOHLEN, mapper.convert(event));
    }
    @EventListener
    public void handle(KreditantragDeniedLocalEvent event){
        bridge.send(SUPPLIER_BINDING_NAME_ABGELEHNT, mapper.convert(event));
    }
}
