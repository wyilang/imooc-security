package com.imooc.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @program: imooc-security
 * @description:oauth资源服务
 * @author: Neo.Wang
 * @create: 2018-04-07 21:01
 **/
@Configuration
@EnableResourceServer
public class ImoocResourceServerConfig {
}
