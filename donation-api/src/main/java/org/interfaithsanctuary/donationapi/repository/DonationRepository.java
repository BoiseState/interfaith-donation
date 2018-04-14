package org.interfaithsanctuary.donationapi.repository;
import org.interfaithsanctuary.donationapi.model.Donation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "donations", path = "donations")
public interface DonationRepository extends PagingAndSortingRepository<Donation, Long> {

    List<Donation> findByDonorId(long donorId);
}