package com.yicj.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
             .requestMatchers()
                .antMatchers("/api/**")
                .antMatchers("/user/api/**")
        ;

    }

    @Primary
    @Bean
    public RemoteTokenServices remoteTokenServices(){
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices() ;
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
        remoteTokenServices.setClientId("clientapp");
        remoteTokenServices.setClientSecret("123456");
        return remoteTokenServices ;
    }
}
