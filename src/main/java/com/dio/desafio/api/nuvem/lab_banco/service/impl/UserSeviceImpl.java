package com.dio.desafio.api.nuvem.lab_banco.service.impl;

import com.dio.desafio.api.nuvem.lab_banco.model.User;
import com.dio.desafio.api.nuvem.lab_banco.repository.UserRepository;
import com.dio.desafio.api.nuvem.lab_banco.service.UserService;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl implements UserService{
    private final UserRepository userRepository;
    
    public UserSeviceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
    
}
