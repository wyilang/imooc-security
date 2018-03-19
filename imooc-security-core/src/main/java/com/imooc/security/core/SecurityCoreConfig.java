package com.imooc.security.core;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-18 14:12
 **/
@Configuration
//让SecurityProperties读取器生效
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
