package app.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.shiro.ShiroRealm;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
		
		sffb.setSecurityManager(securityManager());
		
		sffb.setLoginUrl("/login");
		sffb.setSuccessUrl("/index");
		sffb.setUnauthorizedUrl("/403");
		
		LinkedHashMap<String, String> filterChain = new LinkedHashMap<>();
		// static resource filter
		filterChain.put("/css/**", "anon");
		filterChain.put("/js/**", "anon");
		filterChain.put("/fonts/**", "anon");
		filterChain.put("/images/**", "anon");
		filterChain.put("/login", "anon");
		// logout filter
		filterChain.put("/logout", "logout");
		// other resource need authentication
		filterChain.put("/**", "authc");
		// setting filterChain
		sffb.setFilterChainDefinitionMap(filterChain);
		
		return sffb;
	}
	
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(shiroRealm());
		return defaultWebSecurityManager;
	}
	
	@Bean
	public ShiroRealm shiroRealm() {
		ShiroRealm shiroRealm = new ShiroRealm();
		return shiroRealm;
	}
}
