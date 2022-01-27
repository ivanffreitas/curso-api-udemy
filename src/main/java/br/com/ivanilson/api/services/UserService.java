package br.com.ivanilson.api.services;

import br.com.ivanilson.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
