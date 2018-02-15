package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Alert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "alerts", path = "alerts")
public interface AlertRepository extends CrudRepository<Alert, Long> {

}
