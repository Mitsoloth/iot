package com.codeschool.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.codeschool")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean(name="passwordEncoder")
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.httpBasic().and().authorizeRequests().antMatchers("/*")
//		.hasRole("User").antMatchers("/**").hasRole("Administrator").and()
//		.csrf().disable().headers().frameOptions().disable();

    	//http.authorizeRequests().
    	//antMatchers("/getRoomById/**").hasRole("Administrator").and().csrf().disable().formLogin();
    	
    	http.csrf().disable().authorizeRequests()
    	.antMatchers("/api/**").authenticated()
		//.anyRequest().authenticated()
		.and().httpBasic()
		.authenticationEntryPoint(authEntryPoint);
    	
    	//http
    	//.authorizeRequests()
        //.antMatchers("/getRoomById/*").authenticated()
        //.and()
        //.formLogin()
        //.loginPage("/login/")
        //.defaultSuccessUrl("/inicio/")
        //.usernameParameter("username").passwordParameter("password")
        //.permitAll()
        //.and()
        //.logout()//.logoutSuccessUrl("/login/")
        //.permitAll();
    	
    	//    	http.
//    	authorizeRequests()
//    	.antMatchers("/", "/login", "/hello", "/registration").permitAll()
//		.antMatchers("/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**").permitAll()
//		.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//		.authenticated()
//		.and()
//		.csrf().disable().formLogin()
//		.loginPage("/login").failureUrl("/login?error=true")
//		.defaultSuccessUrl("/home")
//		.usernameParameter("username")
//		.passwordParameter("password")
//		.and()
//			.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/")
//		.and()
//			.exceptionHandling()
//			.accessDeniedPage("/error/403");
    }

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		
//		auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder()).withUser("user1").password("secret1")
//		.roles("USER").and().withUser("admin1").password("$11$TEvA6wDAYh.oEPaCPmSvQe9KfNbjo06EYoj44F1xOiUsA4ohLDa0C")
//		.roles("USER", "ADMIN");
	}
}