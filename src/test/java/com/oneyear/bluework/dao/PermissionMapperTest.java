/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.oneyear.bluework.Application;
import com.oneyear.bluework.model.Permission;
import com.oneyear.bluework.util.RandomUniqueIdGenerator;

/**
 * 
 * @ClassName PermissionMapperTest
 * @Description: TODO
 * @author wei
 * @Date: 2017年7月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Application.class)
public class PermissionMapperTest {
	
	@Autowired
	private PermissionMapper permissionDao;
	
	@Test
 	@Commit
	public void testInsert() {
		Permission newPermission = new Permission(); 
		String permissionId = RandomUniqueIdGenerator.getNewString(16);
		newPermission.setId(permissionId);
		newPermission.setName("ROLE_ADMIN");
		newPermission.setDescription("admin");
		newPermission.setUrl("/admin");
		newPermission.setParentId(null);
		permissionDao.insert(newPermission);
		
//		List<Permission> permissions = permissionDao.findByAdminUserId("rWkdVmPKVOLpXci7");
//		List<Permission> permissions = permissionDao.findAll();
//		assertEquals("ROLE_HOME", permissions.get(0).getName());
	}

}
