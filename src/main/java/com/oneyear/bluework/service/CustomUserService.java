/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oneyear.bluework.dao.BlueMangersMapper;
import com.oneyear.bluework.dao.PermissionMapper;
import com.oneyear.bluework.model.BlueMangers;
import com.oneyear.bluework.model.Permission;

/**
 * @ClassName CustomUserService
 * @Description: TODO
 * @author willie
 * @Date: 2017年7月2日 
 */
@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	private BlueMangersMapper mangerDao;
	
	@Autowired
    private PermissionMapper permissionDao;

	@Override
	public UserDetails loadUserByUsername(String arg0){
		
		BlueMangers manger = mangerDao.findByUserName(arg0);
		 List<Permission> permissions = permissionDao.findByAdminUserId(manger.getId());
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		 for (Permission permission : permissions) {
             if (permission != null && permission.getName()!=null) {

             GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
             //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
             grantedAuthorities.add(grantedAuthority);
             }
         }		
		return new org.springframework.security.core.userdetails.User(manger.getName(),
				manger.getPassword(), grantedAuthorities);
	}

}
