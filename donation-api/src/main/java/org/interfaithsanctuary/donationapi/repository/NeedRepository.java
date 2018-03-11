package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Need;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "needs", path = "needs")
public interface NeedRepository extends PagingAndSortingRepository<Need, Long> {
}
