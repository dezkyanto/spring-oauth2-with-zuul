package com.learn.oauth.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chillyb on 23/01/19.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}