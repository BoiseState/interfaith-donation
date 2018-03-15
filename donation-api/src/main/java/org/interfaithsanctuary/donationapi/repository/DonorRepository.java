package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Donor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "donors", path = "donors")
// Repository REST Resource generates RESTful routes at run-time, no need to create simple Create, Read, Update, and Delete controller routes!
public interface DonorRepository extends PagingAndSortingRepository<Donor, Long> {
}
