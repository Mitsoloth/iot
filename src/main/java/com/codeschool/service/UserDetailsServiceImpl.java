package com.codeschool.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codeschool.entities.Person;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonService userService;
    
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Person user = userService.findByEmail(arg0);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(user!=null) {
//        	if(user.getRole().toString()==1)
        	//System.out.print("HEY EDW EIMAI "+user.getRole().toString());
        		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
//        	if(user.getRole()==2)
//            	grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPpassword(), grantedAuthorities);
	}

}
