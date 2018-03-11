package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "callouts", path = "callouts")
public interface CalloutRepository extends PagingAndSortingRepository<Callout, Long> {
}
