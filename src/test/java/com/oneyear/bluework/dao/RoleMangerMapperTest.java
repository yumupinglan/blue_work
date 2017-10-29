/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.oneyear.bluework.Application;
import com.oneyear.bluework.model.Role;
import com.oneyear.bluework.util.RandomUniqueIdGenerator;

/**
 * 
 * @ClassName RoleMangerMapperTest
 * @Description: TODO
 * @author wei
 * @Date: 2017年7月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Application.class)
public class RoleMangerMapperTest {
	@Autowired
	private RoleMapper roleDao;
	
	@Test
 	@Commit
	public void testInsert() {
		Role newRole = new  Role();
		String id = RandomUniqueIdGenerator.getNewString(16);
		newRole.setId(id);
		newRole.setName("Role_Admin");
		roleDao.insert(newRole);
		
		Role findRole = roleDao.selectByPrimaryKey(id);
		assertEquals("Role_Admin", findRole.getName());
	}
}
