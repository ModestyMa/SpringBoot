package com.modesty.config.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Modesty
 * @Version 2020年4月6日 下午7:24:56
 */

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("1234").roles("ADMIN","USER")
		.and()
		.withUser("bibi").password("123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
//			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//			.anyRequest().authenticated()
//			.and().formLogin().loginPage("/login_page").loginProcessingUrl("/login").usernameParameter("name").passwordParameter("passwd")
//			.successHandler(new AuthenticationSuccessHandler() {
//				@Override
//				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//						Authentication authentication) throws IOException, ServletException {
//					Object principal = authentication.getPrincipal();
//					response.setContentType("application/json;charset=utf-8");
//					PrintWriter out = response.getWriter();
//					response.setStatus(200);
//					Map<String,Object> map = new HashMap<>();
//					map.put("status", 200);
//					map.put("msg", principal);
//					ObjectMapper om = new ObjectMapper();
//					out.write(om.writeValueAsString(map));
//					out.flush();
//					out.close();
//				}
//			}).failureHandler(new AuthenticationFailureHandler() {
//				@Override
//				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//						AuthenticationException exception) throws IOException, ServletException {
//					response.setContentType("application/json;charset=utf-8");
//					PrintWriter out = response.getWriter();
//					response.setStatus(401);
//					Map<String,Object> map = new HashMap<>();
//					map.put("status", 401);
//					if(exception instanceof LockedException) {
//						map.put("msg", "账户被锁定,登录失败!");
//					}else if (exception instanceof BadCredentialsException) {
//						map.put("msg", "账户名或密码输入错误,登录失败!");
//					}else if(exception instanceof DisabledException) {
//						map.put("msg", "账户被禁用,登录失败!");
//					}else if(exception instanceof AccountExpiredException) {
//						map.put("msg", "账户已过期,登录失败!");
//					}else if(exception instanceof CredentialsExpiredException) {
//						map.put("msg", "密码已过期,登录失败!");
//					}else {
//						map.put("msg", "登录失败!");
//					}
//					ObjectMapper om = new ObjectMapper();
//					out.write(om.writeValueAsString(map));
//					out.flush();
//					out.close();
//				}
//			})
//			.and().logout().logoutUrl("/logoutUrl").clearAuthentication(true).invalidateHttpSession(true)
//			.addLogoutHandler(new LogoutHandler() {
//				@Override
//				public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {}
//			})
//			.logoutSuccessHandler(new LogoutSuccessHandler() {
//				@Override
//				public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//						throws IOException, ServletException {
//					response.sendRedirect("/logout_page");
//				}
//			});
	}
}


/**
 * Notes
 */
