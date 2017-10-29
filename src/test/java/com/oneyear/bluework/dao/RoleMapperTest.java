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
import com.oneyear.bluework.model.RoleManger;
import com.oneyear.bluework.util.RandomUniqueIdGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Application.class)
public class RoleMapperTest {
	@Autowired
	private RoleMangerMapper roleMangeDao;
	
	@Test
 	@Commit
	public void testInsert() {
		RoleManger roleManger = new RoleManger();
		String id = RandomUniqueIdGenerator.getNewString(16);
		roleManger.setId(id);
		roleManger.setMangerId("rWkdVmPKVOLpXci7 ");
		roleManger.setRoleId("wRxFEPvFUOiGXboJ");
		roleMangeDao.insert(roleManger);
		RoleManger selectManger = roleMangeDao.selectByPrimaryKey(id);
		assertEquals("rWkdVmPKVOLpXci7", selectManger.getMangerId());
	}
}
