package com.example.clothes.services;

import com.example.clothes.dto.UserView;
import com.example.clothes.mapper.UserViewMapper;
import com.example.clothes.repositories.UserRepository;
import com.example.clothes.security.User;
import com.example.clothes.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private UserViewMapper userViewMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUsername(username);
        user.orElseThrow(()->new UsernameNotFoundException("Not found"+username));
        return user.map(UserDetailsImpl::new).get();

    }
    public List<UserView> findAll(){
        return userViewMapper.toUserView(userRepository.findAll());
    }
    public User add(User user){
        return this.userRepository.save(user);
    }
    public UserView findById(long id){
        User user=userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found"+id));
        return userViewMapper.UsertoUserView(user);

    }

}