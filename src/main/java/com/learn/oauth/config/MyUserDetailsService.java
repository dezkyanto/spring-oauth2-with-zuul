package com.learn.oauth.config;

/**
 * Created by chillyb on 23/01/19.
 */
import com.learn.oauth.appuser.User;
import com.learn.oauth.appuser.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chillyb
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    @Lazy
    public UserRepo userRepo;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User test = userRepo.findByUsername(username);
        return new MyUserPrincipal(test);
    }

}
