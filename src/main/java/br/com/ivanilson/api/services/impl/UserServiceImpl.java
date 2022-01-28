package br.com.ivanilson.api.services.impl;

import br.com.ivanilson.api.domain.User;
import br.com.ivanilson.api.domain.dto.UserDTO;
import br.com.ivanilson.api.repositories.UserRepository;
import br.com.ivanilson.api.services.UserService;
import br.com.ivanilson.api.services.exceptions.DataIntegratyViolationException;
import br.com.ivanilson.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw  new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
