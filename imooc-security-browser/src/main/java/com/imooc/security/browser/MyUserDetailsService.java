package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-12 21:07
 **/
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //调用他的encode方法每此生成的密码加密字符串都不同，即使同一密码两次加密的结果也不一样（实现类BCryptPasswordEncoder）
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名：" + username);
        //return new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        //四个boolean代表UserDetails四个方法中关于用户和密码的四种状态
        String password = passwordEncoder.encode("123456");
        logger.info(password);
        return new User(username, password, true,
        true, true,
        true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
