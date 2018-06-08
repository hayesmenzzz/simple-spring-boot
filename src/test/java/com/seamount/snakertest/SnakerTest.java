package com.seamount.snakertest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seamount.leaveprocess.LeaveSnakerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnakerTest {

	@Autowired
	private LeaveSnakerService leaveSnakerService;
	
	@Test
	public void test(){
		
		String businessId = "777777";
		String operator = "kermit";
		Map<String,Object> variables = new HashMap<String,Object>();
		
		leaveSnakerService.startProcess(businessId, operator, variables);
	}
	
	@Test
	public void test01(){
		String businessId = "8888888";
		String operator = "a1";
		Map<String,Object> variables = new HashMap<String,Object>();
		
		leaveSnakerService.startProcess(businessId, operator, variables);
	}
}
