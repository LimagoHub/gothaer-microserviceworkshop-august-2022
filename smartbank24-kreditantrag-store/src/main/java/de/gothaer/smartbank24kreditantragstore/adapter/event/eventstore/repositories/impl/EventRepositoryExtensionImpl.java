package de.gothaer.smartbank24kreditantragstore.adapter.event.eventstore.repositories.impl;


import de.gothaer.smartbank24kreditantragstore.adapter.event.eventstore.entities.*;
import de.gothaer.smartbank24kreditantragstore.adapter.event.eventstore.repositories.EventRepositoryExtension;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class EventRepositoryExtensionImpl implements EventRepositoryExtension {

    private EntityManager em;

    @Override
    public void save(KreditantragRegistriertInEventEntity entity) {
        em.persist(entity);
    }

    @Override
    public void save(KreditAntragPersistiertOutEventEntity entity) {
        em.persist(entity);
    }

    @Override
    public void save(ScoringPositiveInEventEntity entity) {

        em.merge(entity);
    }

    @Override
    public void save(ScoringNegativInEventEntity entity) {
        em.merge(entity);
    }

    @Override
    public void save(CityScoringPositiveInEventEntity entity) {
        em.merge(entity);
    }

    @Override
    public void save(CityScoringNegativInEventEntity entity) {
        em.merge(entity);
    }

    @Override
    public void save(KreditvertragEmpfohlenOutEventEntity entity) {
        em.merge(entity);
    }

    @Override
    public void save(KreditvertragAbgelehntOutEventEntity entity) {
        em.merge(entity);
    }
}
