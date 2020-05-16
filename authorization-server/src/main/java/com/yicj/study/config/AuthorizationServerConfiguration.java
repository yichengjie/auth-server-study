package com.yicj.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService ;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("clientapp").secret("123456")
                    .accessTokenValiditySeconds(7200)
                    .authorizedGrantTypes("authorization_code","password","refresh_token")
                    .scopes("read_users","all","read","write")
                    .redirectUris("http://localhost:9000/callback") ;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //配置了/oauth/check_token的访问权限为必须是认证过的用户才可以访问 -
        //AuthorizationServer里面配置/oauth/check_token的访问权限，默认是"denyAll"
        security.checkTokenAccess("isAuthenticated()") ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //注意如果要使用密码模式，这里需要添加authenticationManager，否则报错说密码模式不可用
        endpoints.authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
    }
}
