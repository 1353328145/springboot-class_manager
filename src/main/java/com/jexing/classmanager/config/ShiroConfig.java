package com.jexing.classmanager.config;

import com.jexing.classmanager.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置受限资源
        Map<String,String> map=new HashMap<>();
        //   /**表示出了login以外的资源全部受限
        map.put("/user/login","anon"); //这个资源不需要认证
        map.put("/user/register","anon"); //这个资源不需要认证
        map.put("/login","anon"); //这个资源不需要认证
        map.put("/register","anon"); //这个资源不需要认证
        map.put("/css/**","anon");
        map.put("/lay/**","anon");
        map.put("/font/**","anon");
        map.put("/layui.js","anon");
        map.put("/**","authc");
        shiroFilterFactoryBean.setLoginUrl("login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(CustomerRealm customerRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customerRealm);
        return defaultWebSecurityManager;
    }
    @Bean
    //自定义realm
    public CustomerRealm getReam(){
        //设置校验匹配器
        CustomerRealm customerRealm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//设置算法
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }
}
