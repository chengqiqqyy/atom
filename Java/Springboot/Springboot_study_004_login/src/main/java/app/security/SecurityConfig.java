package app.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjars/**","/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/login","/register","/regist").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin().loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/",true)
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login");
			
	}
	
	
}
