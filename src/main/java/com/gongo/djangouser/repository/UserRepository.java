package com.gongo.djangouser.repository;

import com.gongo.djangouser.entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Cacheable( cacheNames = "user")
    Optional<User> findById(long id);

}
