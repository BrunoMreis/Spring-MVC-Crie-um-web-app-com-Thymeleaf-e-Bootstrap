package br.com.alura.mvc.mundi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private javax.sql.DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/home/**")
					.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin(
						form -> form.loginPage("/login")
						.defaultSuccessUrl("/usuario/pedido", true)
						.permitAll()
				)
				.logout(
						logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/home")
						).csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		
		//cria usuário no banco
		/*
		  UserDetails user = User.builder() .username("bruno")
		  .password(encoder.encode("123456")) .roles("ADM") .build();
		 
		*/
		
		 auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .passwordEncoder(encoder);
		 //.withUser(user);
		
	}
	
	
/*	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("bruno")
				.password("123456")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	*/

}
