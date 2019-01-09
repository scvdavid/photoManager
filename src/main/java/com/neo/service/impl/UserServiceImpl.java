package com.neo.service.impl;

import com.neo.entity.User;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
    
    public Page<User> findPaginated(Pageable pageable) {
//    	List<User> users = userRepository.findAll();
//    	
//    	
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage * pageSize;
//        List<User> list;
// 
//        if (users.size() < startItem) {
//            list = Collections.emptyList();
//        } else {
//            int toIndex = Math.min(startItem + pageSize, users.size());
//            list = users.subList(startItem, toIndex);
//        }
// 
//        Page<User> userPage
//          = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());
// 
//        return userPage;
        return userRepository.findAll(pageable);
    }
}


