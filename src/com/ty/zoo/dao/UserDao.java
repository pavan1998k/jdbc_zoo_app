package com.ty.zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.zoo.dto.User;
import com.ty.zoo.util.ConnectionObject;

public class UserDao {
	public int saveVisitor(User user){
		int resultCount=0;
		String sql="INSERT INTO user VALUES(?,?,?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.setString(4, user.getPhone());
			
			resultCount=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCount;
	}
	public User getVisitorById(int id){
		String sql="SELECT * FROM user WHERE id=?";
		Connection connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user=new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				user.setRole(resultSet.getString(5));
				user.setPhone(resultSet.getString(6));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
