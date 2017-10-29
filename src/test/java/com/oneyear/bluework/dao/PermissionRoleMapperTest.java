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
import com.oneyear.bluework.model.PermissionRole;
import com.oneyear.bluework.util.RandomUniqueIdGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Application.class)
public class PermissionRoleMapperTest {
	
	@Autowired
	private PermissionRoleMapper permissionRoleDao;

	@Test
 	@Commit
	public void testInsert() {
		PermissionRole newPR = new PermissionRole();
		String id =  RandomUniqueIdGenerator.getNewString(16);;
		newPR.setId(id);
		newPR.setPermissionId("ndu7bbavIpX2Y9og");
		newPR.setRoleId("wRxFEPvFUOiGXboJ");
		permissionRoleDao.insert(newPR);
		
		PermissionRole pr = permissionRoleDao.selectByPrimaryKey(id);
		assertEquals("ndu7bbavIpX2Y9og", pr.getPermissionId());
		
	}
}
