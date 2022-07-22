package space.eliseev.iplatform.service;

import org.springframework.stereotype.Service;
import space.eliseev.iplatform.model.User;
import space.eliseev.iplatform.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public void addUser(User user){
        repository.save(user);
    }

    public User findUserByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }
}
