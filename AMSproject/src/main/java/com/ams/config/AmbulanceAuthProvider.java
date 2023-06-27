package com.ams.config;

import org.springframework.stereotype.Component;


import com.ams.entity.Staff;
import com.ams.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class AmbulanceAuthProvider implements AuthenticationProvider{
	
	@Autowired
	StaffRepository staffRepository;
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException{
		String userName = authentication.getName();
		String pass = authentication.getCredentials().toString();
		Staff staff = staffRepository.findAllByuserName(userName);
		System.out.println(staff);
		
		//System.out.println("Found Travel object" + staff);
		
		if(staff==null) {
			throw new StackOverflowError("No user got registered");
		}
		else if(pass.equals(staff.getPwd())) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(staff.getDesignation()));
			return new UsernamePasswordAuthenticationToken(userName, pass);
		}else {
			System.out.println("bad credentials");
			throw new StackOverflowError("Invalid Passowrd");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
