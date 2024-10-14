package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.User;
import com.example.inventorymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 从数据库中通过邮箱查找用户
        User user = userRepository.findByEmail(email);
        if(user==null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // 将用户信息转换为Spring Security的UserDetails对象
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())  // 假设角色字段为字符串类型
                .build();
    }
}
