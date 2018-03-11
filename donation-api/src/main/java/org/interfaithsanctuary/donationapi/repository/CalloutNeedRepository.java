package org.interfaithsanctuary.donationapi.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "calloutNeeds", path = "calloutNeeds")
public interface CalloutNeedRepository extends PagingAndSortingRepository<CalloutNeed, Long> {
}