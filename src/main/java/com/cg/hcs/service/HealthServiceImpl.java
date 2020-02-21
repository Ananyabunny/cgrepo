package com.cg.hcs.service;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.dao.HealthDao;
import com.cg.hcs.dao.HealthDaoImpl;
import com.cg.hcs.exception.HealthException;

public class HealthServiceImpl implements HealthService{
	private HealthDao healthDao;
	public HealthServiceImpl()
	{
	 healthDao = new HealthDaoImpl();
	}
	public boolean validateName(String testName) throws HealthException {
		boolean flag =false;
		flag=testName.matches("[a-zA-Z]+");
		return flag;
		}
	public boolean addCenter(DiagnosticCenter center) throws HealthException {
		String name = center.getCenterName();
		boolean flag =name.matches("[a-zA-Z]+");
		if(!flag)
		{
		throw new HealthException("Center name should contain only alphabets");
		}
		Random random = new Random();
		int centerid = random.nextInt(100)+1000;
		String s=Integer.toString(centerid);
		center.setCenterId(s);
		
//		Random random1 = new Random();
//		int id = random1.nextInt(100)+1000;
//		String sf=Integer.toString(id);
//		List<Test>li=center.getListOfTests();
//		for(Test u:li)
//		{
//			u.setTestId(sf);
//		}
		//center.setListOfTests(li);
		healthDao.addCenter(center);
		return false;
	}

	public boolean removeCenter(DiagnosticCenter center) throws HealthException {
		// TODO Auto-generated method stub
		return false;
	}
	public String addTest(String centerName,Test test) throws HealthException {
		String name = test.getTestName();
		boolean flag = validateName(name);
		if(!flag)
		{
		throw new HealthException("Test already present");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		test.setTestId(id+"");
		String sid=healthDao.addTest(centerName,test).toString();
		return sid;
	}

	public boolean removeTest(Test test) throws HealthException {
		String name = test.getTestName();
		boolean flag = validateName(name);
		if(!flag)
		{
		throw new HealthException("Test already present");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		test.setTestId(id+"");
		//String sid=healthDao.removeTest(test).toString();
			return false;
	}

	
	@Override
	public List<DiagnosticCenter> displaycenter() throws HealthException {
		
		return healthDao.displaycenter();
	}
	
	}

	

