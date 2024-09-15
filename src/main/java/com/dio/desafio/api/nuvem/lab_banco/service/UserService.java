package com.dio.desafio.api.nuvem.lab_banco.service;

import org.springframework.stereotype.Service;

import com.dio.desafio.api.nuvem.lab_banco.model.User;

@Service
public interface UserService {
    
    User findById(Long id);
    User create(User userToCreate);
}
