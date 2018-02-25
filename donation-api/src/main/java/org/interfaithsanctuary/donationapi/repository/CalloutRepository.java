package org.interfaithsanctuary.donationapi.repository;

import org.interfaithsanctuary.donationapi.model.Callout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CalloutRepository extends CrudRepository<Callout, Long> {

}
