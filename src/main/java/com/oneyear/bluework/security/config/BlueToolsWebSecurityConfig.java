/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.oneyear.bluework.service.BlueMangerFilterSecurityInterceptor;
import com.oneyear.bluework.service.CustomUserService;
import com.oneyear.bluework.util.MD5Util;

/**
 * @ClassName BlueToolsWebSecurityConfig
 * @Description: TODO
 * @author willie
 * @Date: 2017年7月2日 
 */
@Configuration
@EnableWebSecurity
public class BlueToolsWebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BlueMangerFilterSecurityInterceptor myFilterSecurityInterceptor;
	
	@Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }}); //user Details Service验证);

    }
    
    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/css/**","/js/**","/img/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()   	
        .anyRequest().authenticated() //任何请求,登录后可以访问
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/")
        .failureUrl("/login?error")
        .permitAll() //登录页面用户任意访问
        .and()
        .logout().permitAll(); //注销行为任意访问

    	 http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
