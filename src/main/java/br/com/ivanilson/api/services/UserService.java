package br.com.ivanilson.api.services;

import br.com.ivanilson.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
