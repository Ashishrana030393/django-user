package com.gongo.djangouser.service;

import com.gongo.djangouser.entity.User;
import com.gongo.djangouser.repository.UserRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(long id){
        return this.userRepository.findById(id);
    }

    @Override
    public User createUser(User user){
       return save(user);
    }

    @CachePut(cacheNames = "user")
    private User save(User user){
        return this.userRepository.save(user);
    }

    @Override
    public void updateUser(User user){
        Optional<User> byId = this.userRepository.findById(user.getId());
        if(byId.isPresent()){
            User u = byId.get();
            u.setUsername(user.getUsername());
            save(u);
        }
    }
}
