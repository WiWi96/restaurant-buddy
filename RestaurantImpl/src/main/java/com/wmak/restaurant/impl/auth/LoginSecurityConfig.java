package com.wmak.restaurant.impl.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userService;
	 
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		/**
		 * Necessary to use h2 console.
		 */
		http.headers().frameOptions().disable();
		http
			.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("admin/**").hasRole("ADMIN")
				.antMatchers("/swagger-ui.html").hasRole("ADMIN")//API page
				.antMatchers("/swagger-ui.html#!/").hasRole("ADMIN")
				.antMatchers("/h2").hasRole("ADMIN")//Database console
				.antMatchers("/h2/").hasRole("ADMIN")
				.antMatchers("/user/**").hasRole("USER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
			
	}
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }
	
}
