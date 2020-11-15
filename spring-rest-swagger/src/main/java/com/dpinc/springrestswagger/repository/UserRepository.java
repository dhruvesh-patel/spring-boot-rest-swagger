package com.dpinc.springrestswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpinc.springrestswagger.model.User;

/**
 * User Repository 
 * @author Dhruvesh
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
