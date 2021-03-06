package com.portfolio.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.entity.Usuario;
import com.portfolio.service.UserService;

@Service("userDetails")
public class MyUserDetails implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
	
		Usuario user = userService.obterCPF(cpf);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        UserDetails userDetails = new User(
        		user.getCpf(),
        		user.getSenha(),
        		user.getEnabled(),
                true,
                true,
                true,
                authorities);
        
        return userDetails;
        
	}

}
