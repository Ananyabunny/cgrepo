package com.cg.hcs.service;
import java.util.Date;
import java.util.List;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.HealthException;
public interface HealthService {
	
	public	boolean validateName(String testName) throws HealthException;
	 public	boolean addCenter(DiagnosticCenter center) throws HealthException;
	 public	boolean removeCenter(DiagnosticCenter center) throws HealthException;
		
	 public	String addTest(String centerName,Test test) throws HealthException;
		
	 public	boolean removeTest(Test test) throws HealthException;
	 public List<DiagnosticCenter>displaycenter()throws HealthException;
}