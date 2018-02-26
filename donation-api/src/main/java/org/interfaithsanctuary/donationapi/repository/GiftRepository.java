package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Gift;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "gifts", path = "gifts")
public interface GiftRepository extends PagingAndSortingRepository<Gift, Long> {

}