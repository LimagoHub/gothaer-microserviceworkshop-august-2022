package de.gothaer.smartbank24kreditantragstore.adapter.repositories;


import org.springframework.data.repository.CrudRepository;
import de.gothaer.smartbank24kreditantragstore.adapter.repositories.entities.KreditantragEntity;

public interface KreditantragPersistence extends CrudRepository<KreditantragEntity, String> {
}
