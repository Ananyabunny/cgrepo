package com.cg.hcs.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.HealthException;
public class HealthDaoImpl implements HealthDao {
	private Map<String,Test> map;
	HashMap<String,DiagnosticCenter> centerMap;
	HashMap<String,Appointment> appointmentMap;
	ArrayList<Test>listofTests =new ArrayList<Test>();
	public HealthDaoImpl()
	{
		centerMap=new HashMap<String,DiagnosticCenter>();
		appointmentMap=new HashMap<String,Appointment>();
	}
	public boolean addCenter(DiagnosticCenter center) throws HealthException {
		
		Test bloodpressure=new Test();
		bloodpressure.setTestId("45");
		bloodpressure.setTestName("blood pressure");
		Test bloodtest=new Test();
		bloodtest.setTestId("46");
		bloodtest.setTestName("blood test");
		Test bloodsugar=new Test();
		bloodsugar.setTestId("47");
		bloodsugar.setTestName("blood sugar");
		listofTests.add(bloodpressure);
		listofTests.add(bloodtest);
		listofTests.add(bloodsugar);
		center.setListOfTests(listofTests);
		centerMap.put(center.getCenterId(),center);
		return false;
	}
	public boolean removeCenter(DiagnosticCenter center) throws HealthException {
		
		return false;
	}
	public String addTest(Test test) throws HealthException {
		//List<DiagnosticCenter> list=center.stream().filter(p->p.getcenterId==centerId?true:false).map(p->p.getListOfTests());
		Set<String> s=centerMap.keySet();
		DiagnosticCenter center=new DiagnosticCenter();
		String s1=test.getTestName();
		for (String i :s) {
			boolean flag =centerMap.equals(i);
			if(flag==true)
			{
			List<Test>list=center.getListOfTests();
			boolean flag1 =	list.contains(test.getTestId());
			if(flag==true)
			{
			throw new HealthException("ID already exist");
			}
			else
			{
			list.add(test);
			}
			}
		}
		 /*boolean flag = map.containsKey(test.getTestId()) ;
		if(flag==true)
		{
		throw new HealthException("ID already exist");
		}
		else
		{
		map.put(test.getTestId(), test);
		}*/
		return test.getTestId();
		
		}
	public boolean removeTest(Test testId) throws HealthException {
		boolean flag = map.containsKey(testId) ;
		if(flag)
		{
		testId = map.remove(testId);
		}
		else
		{
		throw new HealthException(testId+" not found");
		}
		return flag;
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
	public String register(User User) throws HealthException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
