package com.cg.hcs.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import com.cg.hcs.bean.Appointment;
import com.cg.hcs.bean.DiagnosticCenter;
import com.cg.hcs.bean.Test;
import com.cg.hcs.bean.User;
import com.cg.hcs.exception.HealthException;
public class HealthDaoImpl implements HealthDao {
	private Map<String,Test> map;
private	HashMap<String,DiagnosticCenter> centerMap;
  private	HashMap<String,Appointment> appointmentMap;
	public HealthDaoImpl()
	{
		centerMap=new HashMap<String,DiagnosticCenter>();
		appointmentMap=new HashMap<String,Appointment>();
	}
	public boolean addCenter(DiagnosticCenter center) throws HealthException 
		{
			if(centerMap.containsKey(center.getCenterId()))
			{
				throw new HealthException("center already exist");
			}
			else
			{
				
				List<Test>list=new ArrayList<Test>();
				Test test=new Test();
				test.setTestId("1");
				test.setTestName("blood test");
				list.add(test);
				Test test1=new Test();
				test1.setTestId("2");
				test1.setTestName("blood group");
				list.add(test1);
				Test test2=new Test();
				test2.setTestId("3");
				test2.setTestName("blood pressure");
				list.add(test2);
				center.setListOfTests(list);
				
				centerMap.put(center.getCenterId(), center);
		}
	return true; 
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
			boolean flag =s1.equals(i);
			List<Test>list=center.getListOfTests();
			//boolean flag1 =	list.contains(test.getTestId());
			if(flag==true)
			{
			throw new HealthException("test already exist");
			}
			//else
			///{
			list.add(test);
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
	@Override
	public List<DiagnosticCenter> displaycenter() throws HealthException {
		Collection<DiagnosticCenter> col=centerMap.values();
		List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>(col);
		return list;
	}
	
}
