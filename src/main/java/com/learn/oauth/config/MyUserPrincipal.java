package com.learn.oauth.config;

/**
 * Created by chillyb on 23/01/19.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.learn.oauth.appuser.User;
import com.learn.oauth.appuser.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author chillyb
 */

@Component
public class MyUserPrincipal implements UserDetails{

    //@Autowired
    private User user;
    
    @Autowired
    public UserRepo userRepo;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List auth = new ArrayList<SimpleGrantedAuthority>();
        auth.add(new SimpleGrantedAuthority("ADMIN"));
        return auth;
    }

    @Override
    public String getPassword() {
        //return "$2a$10$h210kjdhqB1z7vjnWzRxD.qXMozDU73Pcj8dMG61JqEPyTrxIaHWy";
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
