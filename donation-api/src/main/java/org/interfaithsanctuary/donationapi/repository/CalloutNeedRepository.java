package org.interfaithsanctuary.donationapi.repository;
import com.sun.istack.internal.Nullable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.interfaithsanctuary.donationapi.model.CalloutNeed;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "calloutNeeds", path = "calloutNeeds")
public interface CalloutNeedRepository extends PagingAndSortingRepository<CalloutNeed, Long> {

    @Nullable
    List<CalloutNeed> findByCalloutId(@Nullable long calloutId);
}