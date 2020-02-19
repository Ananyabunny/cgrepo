package com.cg.hcs.service;
import java.util.Date;

import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.HealthException;
public interface HealthService {
	
	public	String ValidateName(User user) throws HealthException;
	public	int ValidatePassword(User user) throws HealthException;
	public	int ValidatePhoneNo(User user) throws HealthException;
	 public	boolean addCenter(DiagnosticCenter center) throws HealthException;
	 public	boolean removeCenter(DiagnosticCenter center) throws HealthException;
		
	 public	String addTest(Test test) throws HealthException;
		
	 public	boolean removeTest(Test test) throws HealthException;
	 public	boolean approveAppointement() throws HealthException;
	 public	String makeanAppointement(User user,DiagnosticCenter center, Test test,Date datetime) throws HealthException;
	 public	String register(User user) throws HealthException;
	 
}