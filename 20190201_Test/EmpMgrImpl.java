package com.ssafy.emp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class EmpMgrImpl implements IEmpMgr {

	/** 직원나 매니저의 정보를 저장하기 위한 리스트 */
	private List<Employee> emps = new ArrayList<Employee>();

	private EmpMgrImpl() {
		load("emp.dat");
	}

	private static EmpMgrImpl instance;

	public static EmpMgrImpl getInstance() {
		if (instance == null) {
			instance = new EmpMgrImpl();
		}
		return instance;
	}

	/** 파일로 부터 자료 읽어서 메모리(ArrayList)에 저장하기 */
	public void load(String filename) {
		File file = new File(filename);
		System.out.println(file);
		if (!file.exists())
			return;
		emps.clear();
		ObjectInputStream ois = null;
		Object ob = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			while (true) {// 마지막 EOF Exception발생
				ob = ois.readObject();
				emps.add((Employee) ob);
			}
		} catch (EOFException ee) {
			System.out.println("읽기 완료");
		} catch (FileNotFoundException fe) {
			System.out.println("파일이 존재하지 않습니다");
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (ClassNotFoundException ce) {
			System.out.println("같은 클래스 타입이 아닙니다");
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException oe) {
					System.out.println("파일을 닫는데 실패했습니다");
				}
			}
		}
	}

	public List<Employee> search() {
		return emps;
	}

	@Override
	public void save(String filename) throws Exception {
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (Employee p : emps) {
			oos.writeObject(p);
		}
		oos.close();
		fos.close();
	}

	@Override
	public void add(Employee b) throws DuplicateException {
		for (Employee e : emps) {
			if (e.getName().equals(b.getName()))
				throw new DuplicateException();
		}
		emps.add(b);
	}

	@Override
	public Employee search(int num) throws RecordNotFoundException {
		int index = 0;
		for (Employee e : emps) {
			if (e.getEmpNo() == num) {
				index++;
				return e;
			}

		}
		if(index==0)
			throw new RecordNotFoundException();
		
		return null;
	}

	@Override
	public void update(Employee b) throws RecordNotFoundException {
		int index = 0;
		for(Employee e: emps)
		{
			if(e.getEmpNo()==b.getEmpNo())
			{
				break;
			}
			index++;
		}
		if(index==emps.size()-1)
			throw new RecordNotFoundException();
		
		emps.get(index).setDept(b.getDept());
		emps.get(index).setEmpNo(b.getEmpNo());
		emps.get(index).setName(b.getName());
		emps.get(index).setDept(b.getDept());
	}

	@Override
	public void delete(int num) throws RecordNotFoundException {
		int index = 0;
		for(Employee e : emps) {
			if(e.getEmpNo() == num)
			{
				break;
			}
			index++;
		}
		if(index==emps.size()-1)
			throw new RecordNotFoundException();
System.out.println(index);
	}

}
