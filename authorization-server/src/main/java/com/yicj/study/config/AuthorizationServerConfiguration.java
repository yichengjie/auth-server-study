package com.yicj.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("clientapp")
                .secret("123456").authorizedGrantTypes("authorization_code")
                .redirectUris("http://localhost:9000/callback").scopes("read_users") ;
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //配置了/oauth/check_token的访问权限为必须是认证过的用户才可以访问 -
        //AuthorizationServer里面配置/oauth/check_token的访问权限，默认是"denyAll"
        security.checkTokenAccess("isAuthenticated()") ;
    }
}
