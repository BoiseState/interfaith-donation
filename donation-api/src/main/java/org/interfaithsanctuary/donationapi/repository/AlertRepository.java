package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alerts", path = "alerts")
public interface AlertRepository extends CrudRepository<Alert, Long> {

}
