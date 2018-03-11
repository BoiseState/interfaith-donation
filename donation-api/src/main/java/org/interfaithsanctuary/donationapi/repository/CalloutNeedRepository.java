package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "calloutNeeds", path = "calloutNeeds")
public interface CalloutNeedRepository extends CrudRepository<CalloutNeed, Long> {
}
