package com.cg.hcs.service;

import java.util.Date;
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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeCenter(DiagnosticCenter center) throws HealthException {
		// TODO Auto-generated method stub
		return false;
	}
	public String addTest(Test test) throws HealthException {
		String name = test.getTestName();
		boolean flag = validateName(name);
		if(!flag)
		{
		throw new HealthException("Test already present");
		}
		Random random = new Random();
		int id = random.nextInt(100)+1000;
		test.setTestId(id+"");
		String sid=healthDao.addTest(test).toString();
		return sid;
	}

	public boolean removeTest(Test test) throws HealthException {
		if(testList.remove(test))
			return true;
		else
			return false;
	}

	public boolean approveAppointement() throws HealthException {
		// TODO Auto-generated method stub
		return false;
	}

	public String makeanAppointement(User user, DiagnosticCenter center, Test test, Date datetime)
			throws HealthException {
		// TODO Auto-generated method stub
		return null;
	}

	public String register(User user) throws HealthException {
		// TODO Auto-generated method stub
		return null;
	}


	public String ValidateName(User user) throws HealthException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
