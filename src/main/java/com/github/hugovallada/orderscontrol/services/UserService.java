package com.github.hugovallada.orderscontrol.services;

import com.github.hugovallada.orderscontrol.entities.User;
import com.github.hugovallada.orderscontrol.repositories.UserRepository;
import com.github.hugovallada.orderscontrol.services.exceptions.DatabaseException;
import com.github.hugovallada.orderscontrol.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.getOne(id);
            updateData(entity, user);
            
            return repository.save(entity);

        } catch (EntityNotFoundException e) {

            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
