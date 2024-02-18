package com.rdcruz.savingstracker.domain.repository;

import com.rdcruz.savingstracker.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
//        (collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, String> {
}