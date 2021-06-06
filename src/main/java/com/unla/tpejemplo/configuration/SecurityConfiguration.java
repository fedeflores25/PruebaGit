package com.unla.tpejemplo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.unla.tpejemplo.services.implentation.UsuarioService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/css/*","/imgs/*","/js/*","/vendor/*").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
			.usernameParameter("username").passwordParameter("password")
			.defaultSuccessUrl("/loginsuccess").permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
		
	}
}
