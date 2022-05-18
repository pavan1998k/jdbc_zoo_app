package com.ty.zoo.services;

import static com.ty.zoo.util.AppConstants.SECRET_KEY;

import com.ty.zoo.dao.UserDao;
import com.ty.zoo.dto.User;
import com.ty.zoo.util.AES;

public class UserService {
	UserDao userDao=new UserDao();

	public int saveVisitor(User user) {
		String encPassword=AES.encrypt(user.getPassword(), SECRET_KEY);
		user.setPassword(encPassword);
		return userDao.saveVisitor(user);
	}
	public User getVisitorById(int id) {
		User visitor=userDao.getVisitorById(id);
		String decPassword=AES.decrypt(visitor.getPassword(), SECRET_KEY);
		
		visitor.setPassword(decPassword);;
		return visitor;
	}
}
