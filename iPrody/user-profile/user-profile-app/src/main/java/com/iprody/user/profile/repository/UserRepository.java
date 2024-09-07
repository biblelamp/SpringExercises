package com.iprody.user.profile.repository;

import com.iprody.user.profile.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, Integer> {
}
