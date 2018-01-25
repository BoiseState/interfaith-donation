package org.interfaithsanctuary.donationapi;

import org.interfaithsanctuary.donationapi.model.Users;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Long> {

}