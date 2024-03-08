package com.tobeto.bootcampproject.business.rules;

import com.tobeto.bootcampproject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampproject.model.entities.User;
import com.tobeto.bootcampproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private UserRepository userRepository;
    public void checkIfEmailExist(
    String email
    ){
        User user =userRepository.getByEmail(email.trim());
        if(user!=null){
            throw new BusinessException("This email is already used!");
        }
    }
    public void checkIfUserNameExist(
    String userName
    ){
        User user =userRepository.findByuserName(userName);
        if(user!=null){
            throw new BusinessException("This userName is already used!");
        }
    }
    public void checkIfNationalIdentıtyExist(
    String nationalIdentity
    ){
        User user =userRepository.findBynationalIdentity(nationalIdentity);
        if(user!=null){
            throw new BusinessException("This nationalIdentity is already used!");
        }

    }
}
