package app.config;

import java.util.LinkedHashMap;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.shiro.ShiroRealm;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// Setting securityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// login URL
		shiroFilterFactoryBean.setLoginUrl("/login");
		// login success URL
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// noAuthentication URL
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		// Setting filterChain, don't intercept static resource
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/image/**", "anon");
		// don't intercept druid monitoring page
		filterChainDefinitionMap.put("/druid/**", "anon");
		// Setting login
		filterChainDefinitionMap.put("/login", "anon");
		// Setting userList
		filterChainDefinitionMap.put("/userList", "anon");
		// Setting logout 
		filterChainDefinitionMap.put("/logout", "logout");
		// Except above URL, all need authentication
		filterChainDefinitionMap.put("/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	
	@Bean
	public SecurityManager securityManager() {
		// Setting SecurityManager and Inject shiroRealm
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		securityManager.setRememberMeManager(cookieRemeberMeManager());
		return securityManager;
	}
	
	@Bean
	public ShiroRealm shiroRealm() {
		// Setting Realm, need achieving it by yourself
		ShiroRealm shiroRealm = new ShiroRealm();
		return shiroRealm;
	}
	
	// Cookie Object
	public SimpleCookie rememberMeCookie() {
		// Setting cookie name, refer to login page's 'rememberMe' checkbox
		// <input type='checkbox' name='rememberMe'/>
		SimpleCookie reMeCookie = new SimpleCookie("rememberMe");
		// Setting cookie's life (Unit : seconds)
		reMeCookie.setMaxAge(5*60);
		return reMeCookie;
	}
	
	// Cookie Manager Object
	public CookieRememberMeManager cookieRemeberMeManager() {
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		rememberMeManager.setCookie(rememberMeCookie());
		// rememberMe Cookie secret key
		rememberMeManager.setCipherKey(Base64.decode("V2hhdCBUaGUgSGVsbAAAAA=="));
		return rememberMeManager;
	}
	
	
	
	
	
	
	
	
	
}
