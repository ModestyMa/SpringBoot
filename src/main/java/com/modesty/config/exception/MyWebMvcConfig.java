package com.modesty.config.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.modesty.config.filter.MyInterceptor;

/**
 * @author Modesty
 * @Version 2020年4月5日 下午5:21:49
 */

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/book/**")
		.allowedHeaders("*")
		.allowedMethods("*")
		.maxAge(1800)
		.allowedOrigins("http://localhost:8082");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello");
	}
}


/**
 * Notes
 * 全局配置跨域请求
 * 拦截器配置
 */
