package com.service;

import com.entity.Authority;
import com.entity.User;
import com.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qbanxiaoli
 * @description
 * @create 2018/12/7 16:03
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("登录用户: " + user.getUsername());
        log.info("用户ID: " + user.getUuid());
        log.info("用户权限列表:");
        user.getAuthorityList().forEach(authority -> {
            log.info(authority.getAuthority());
        });
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (Authority role : user.getAuthorityList()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        user.setAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值
        return user;
    }

}
