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
		// .antMatchers(HttpMethod.GET,"/api/ventas/{id}").hasAnyRole("USER","ADMIN")
		// Crud Ventas
		// Crud Productos
		.antMatchers(HttpMethod.GET, "/prod/sel").permitAll()
		.antMatchers(HttpMethod.GET, "/prod/sel/{prodid}").permitAll()
		.antMatchers(HttpMethod.GET, "/prod/sel/filtrar-productos/{term}").permitAll()
		.antMatchers(HttpMethod.POST, "/prod/add").permitAll()
		.antMatchers(HttpMethod.POST, "/prod/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/prod/del/{prodid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/prod/upd/{prodid}").permitAll()
		.antMatchers(HttpMethod.GET, "/prod/sel/{fechaini}/{fechafin}").permitAll()
		.antMatchers(HttpMethod.GET, "/prod/uploads/img/**").permitAll()
		
		.antMatchers(HttpMethod.GET, "/adq/sel").permitAll().antMatchers(HttpMethod.GET, "/adq/sel/{adqid}")
		.permitAll().antMatchers(HttpMethod.POST, "/adq/add").permitAll()
		.antMatchers(HttpMethod.POST, "/adq/upload").permitAll()
		.antMatchers(HttpMethod.GET, "/adq/adq/{adqid}").permitAll()
		.antMatchers(HttpMethod.DELETE, "/adq/del/{adqid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/adq/upd/{adqid}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/usr/sel").permitAll().antMatchers(HttpMethod.GET, "/usr/sel/{userid}").permitAll()
		/*.antMatchers(HttpMethod.POST, "/adq/upload").permitAll()
		.antMatchers(HttpMethod.GET, "/adq/adq/{adqid}").permitAll()
		.antMatchers(HttpMethod.DELETE, "/adq/del/{adqid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/adq/upd/{adqid}").permitAll()*/
			
		
		
		.antMatchers(HttpMethod.GET, "/comp/sel").permitAll().antMatchers(HttpMethod.GET, "/comp/sel/{venid}")
		.permitAll().antMatchers(HttpMethod.POST, "/comp/add").permitAll()
		.antMatchers(HttpMethod.POST, "/comp/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/comp/del/{catid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/comp/upd/{catid}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/prov/sel").permitAll().antMatchers(HttpMethod.GET, "/prov/sel/{provid}")
		.permitAll().antMatchers(HttpMethod.POST, "/prov/add").permitAll()
		.antMatchers(HttpMethod.POST, "/prov/upload").permitAll()
		.antMatchers(HttpMethod.GET, "/prov/sel/filtrar-proveedores/{term}").permitAll()
		.antMatchers(HttpMethod.DELETE, "/prov/del/{provid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/prov/upd/{provid}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/cat/sel").permitAll().antMatchers(HttpMethod.GET, "/cat/sel/{catid}")
		.permitAll().antMatchers(HttpMethod.POST, "/cat/add").permitAll()
		.antMatchers(HttpMethod.POST, "/cat/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/cat/del/{catid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/cat/upd/{catid}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/gru/sel").permitAll().antMatchers(HttpMethod.GET, "/gru/sel/{gruid}")
		.permitAll().antMatchers(HttpMethod.POST, "/gru/add").permitAll()
		.antMatchers(HttpMethod.POST, "/gru/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/gru/del/{gruid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/gru/upd/{gruid}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/vent/sel").permitAll().antMatchers(HttpMethod.GET, "/vent/sel/{ventid}")
		.permitAll().antMatchers(HttpMethod.POST, "/vent/add").permitAll()
		.antMatchers(HttpMethod.POST, "/vent/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/vent/del/{ventid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/vent/upd/{ventid}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/ent/sel").permitAll().antMatchers(HttpMethod.GET, "/ent/sel/{ventid}")
		.permitAll().antMatchers(HttpMethod.POST, "/ent/add").permitAll()
		.antMatchers(HttpMethod.POST, "/ent/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/ent/del/{ventid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/ent/upd/{ventid}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/con/sel").permitAll().antMatchers(HttpMethod.GET, "/con/sel/{conid}")
		.permitAll().antMatchers(HttpMethod.POST, "/con/add").permitAll()
		.antMatchers(HttpMethod.POST, "/con/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/con/del/{conid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/con/upd/{conid}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/cli/sel").permitAll()
		.antMatchers(HttpMethod.GET, "/cli/sel/{cliid}").permitAll()
		.antMatchers(HttpMethod.GET, "/cli/sel/fechanac/{fechaini}/{fechafin}").permitAll()
		.antMatchers(HttpMethod.POST, "/cli/add").permitAll()
		.antMatchers(HttpMethod.POST, "/cli/upload").permitAll()
		.antMatchers(HttpMethod.DELETE, "/cli/del/{cliid}").permitAll()
		.antMatchers(HttpMethod.PUT, "/cli/upd/{cliid}").permitAll()
		
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
