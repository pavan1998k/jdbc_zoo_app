package com.ty.zoo.controller;

import com.ty.zoo.dao.VisitorDao;
import com.ty.zoo.dto.Visitor;

public class TestVisitor {
	public static void main(String[] args) {
		Visitor visitor=new Visitor();
		visitor.setId(1);
		visitor.setName("Pavan");
		visitor.setEmail("pk@gmail.com");
		visitor.setPhone("7411920739");
		visitor.setGender("Male");
		visitor.setAge(23);

		VisitorDao visitorDao=new VisitorDao();
		visitorDao.saveVisitor(visitor);
	}
}
