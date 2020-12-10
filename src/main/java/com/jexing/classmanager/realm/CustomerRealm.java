package com.jexing.classmanager.realm;

import com.jexing.classmanager.entity.Rank;
import com.jexing.classmanager.entity.User;
import com.jexing.classmanager.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User current = userService.getUserByName((String) principalCollection.getPrimaryPrincipal());
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        System.out.println("用户授权"+current);
        if (current==null){
            return null;
        }else{
            Rank rank = current.getRank();
            switch (rank.getRank()){
                case 1: simpleAuthenticationInfo.addRole("user");break;
                case 2: simpleAuthenticationInfo.addRole("admin");break;
                case 3: simpleAuthenticationInfo.addRole("root");break;
                default:return null;
            }
        }
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        User currentUser = userService.getUserByName((String) authenticationToken.getPrincipal());
        if (currentUser==null){//用户不存在登陆失败
            return null;
        }else{
            return new SimpleAuthenticationInfo(currentUser.getName(),currentUser.getPassword(),this.getName());
        }
    }
}
