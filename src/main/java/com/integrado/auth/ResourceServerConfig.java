package com.integrado.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/cat/sel").permitAll()
		.antMatchers(HttpMethod.GET, "/cat/sel/filtrar-categorias/{term}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/usr/sel").permitAll().antMatchers(HttpMethod.GET, "/usr/sel/{userid}").permitAll()

		.antMatchers(HttpMethod.GET, "/dvr/sel").permitAll().antMatchers(HttpMethod.GET, "/dvr/sel/{iddvr}")
		.permitAll().antMatchers(HttpMethod.POST, "/dvr/add").permitAll()
		.antMatchers(HttpMethod.POST, "/dvr/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/dvr/del/{iddvr}").permitAll()
		.antMatchers(HttpMethod.PUT, "/dvr/upd/{iddvr}").permitAll()
		

				
		.anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));  //endpoint que consumira servicios
		//config.setAllowedOrigins(Arrays.asList("http://mi.empresa.bo"));   //entpoint para produccion
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
