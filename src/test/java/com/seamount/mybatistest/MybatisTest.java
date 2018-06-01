package com.seamount.mybatistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seamount.dao.model.City;
import com.seamount.dao.service.CityService;

/**
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

	@Autowired
	private CityService cityService;
	
	@Test
	public void test(){
		City id = cityService.getById(1);
		System.out.println(id.toString());
	}
}
