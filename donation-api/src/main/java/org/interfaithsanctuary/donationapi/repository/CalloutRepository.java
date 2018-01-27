package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "callouts", path = "callouts")
public interface CalloutRepository extends CrudRepository<Callout, Long> {

}
