/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.oneyear.bluework.Application;
import com.oneyear.bluework.model.BlueMangers;
import com.oneyear.bluework.util.MD5Util;
import com.oneyear.bluework.util.RandomUniqueIdGenerator;


/**
 * @ClassName BlueMangersMapperTest
 * @Description: TODO
 * @author willie
 * @Date: 2017年6月19日 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Application.class)
public class BlueMangersMapperTest {
	
	@Autowired
	private BlueMangersMapper mapper;
	 	@Test
	 	@Commit
	    public void testInsertList() {
	 		BlueMangers manger = new BlueMangers();
	 		manger.setId(RandomUniqueIdGenerator.getNewString(16));
	 		manger.setName("test_sys");
	 		manger.setLevel(1);
	 		manger.setPassword(MD5Util.encode("test"));
	 		int value = mapper.insert(manger);
	 		assertEquals(1, value);
//	 		BlueMangers newmanger = mapper.findByUserName("test");
//	 		System.out.println(newmanger.getName());
//	 		assertNotNull(newmanger);
	 		
	    }

}
