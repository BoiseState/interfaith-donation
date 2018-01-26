package org.interfaithsanctuary.donationapi.controller;

import org.interfaithsanctuary.donationapi.model.Need;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "needs", path = "needs")
public interface NeedRepository extends CrudRepository<Need, Long> {
}
