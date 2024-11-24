package ru.VladHendel.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.VladHendel.domain.Role;
import ru.VladHendel.domain.User;
import ru.VladHendel.repos.UsersRepo;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepo.findByUsername(username);
    }

    public boolean addUser (User user){
        User userFromDb = usersRepo.findByUsername(user.getUsername());
        if (userFromDb != null){
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepo.save(user);
        return true;
    }

    @Transactional
    public boolean deleteById(Long userId) {
        Optional<User> user = usersRepo.findById(userId); // Ищем пользователя по ID
        if (user.isPresent()) {
            usersRepo.deleteById(userId); // Удаляем, если пользователь существует
            return true;
        }
        return false; // Возвращаем false, если пользователь не найден
    }

    public List<User> findAll(){
        return usersRepo.findAll();
    }

    public User findByUsername(String username){return usersRepo.findByUsername(username);}

    public void saveUser (User user, String username, String[] roles){
        user.setUsername(username);
        user.getRoles().clear();

        if (roles != null) {
            for (String role : roles) {
                user.getRoles().add(Role.valueOf(role));
            }
        }

        usersRepo.save(user);
    }
 }
