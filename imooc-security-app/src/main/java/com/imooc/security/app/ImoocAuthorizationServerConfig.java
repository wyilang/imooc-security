package com.imooc.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @program: imooc-security
 * @description:oauth认证服务
 * @author: Neo.Wang
 * @create: 2018-04-07 17:41
 **/
@Configuration
//认证服务器的注解
@EnableAuthorizationServer
public class ImoocAuthorizationServerConfig {
}
