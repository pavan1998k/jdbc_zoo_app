package com.ty.zoo.services;

import com.ty.zoo.dao.VisitorDao;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.AES;
import static com.ty.zoo.util.AppConstants.SECRET_KEY;


public class VisitorService {
	VisitorDao visitorDao=new VisitorDao();
	
	public int saveVisitor(Visitor visitor) {
		String encName=AES.encrypt(visitor.getName(), SECRET_KEY);
		String encEmail=AES.encrypt(visitor.getEmail(), SECRET_KEY);
		String encPhone=AES.encrypt(visitor.getPhone(), SECRET_KEY);
		
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		return visitorDao.saveVisitor(visitor);
	}
	public Visitor getVisitorById(int id) {
		Visitor visitor=visitorDao.getVisitorById(id);
		String decName=AES.decrypt(visitor.getName(), SECRET_KEY);
		String decEmail=AES.decrypt(visitor.getEmail(), SECRET_KEY);
		String decPhone=AES.decrypt(visitor.getPhone(), SECRET_KEY); 
		
		visitor.setName(decName);
		visitor.setEmail(decEmail);
		visitor.setPhone(decPhone);
		return visitor;
	}
}
