package com.spring.data.neo4j.service;

import com.spring.data.neo4j.dto.Login;
import com.spring.data.neo4j.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */
@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public List<Login> findByUser(String user){
        return loginRepository.findByUser(user);
    }

    public List<Login> findAllLogin(){
        return loginRepository.findAllLogin();
    }

    public List<Login> findBy(String type,Object value){
        return loginRepository.findBy(type,value);
    }

    @Transactional(readOnly = false)
    public List<Login> createLogin(Login login){
        Login lo=loginRepository.save(login);
        if (lo!=null){
            return findAllLogin();
        }else {
            return null;
        }
    }

    @Transactional(readOnly = false)
    public Boolean delete(Long id){
        Login logins=loginRepository.findOne(id);
        if (logins!=null){
            loginRepository.delete(id);
            return true;
        }else {
            return false;
        }
    }
}
