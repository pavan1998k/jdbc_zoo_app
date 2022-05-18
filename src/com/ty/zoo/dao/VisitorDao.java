package com.ty.zoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.zoo.dto.Visitor;

import com.ty.zoo.util.ConnectionObject;

public class VisitorDao {
	public int saveVisitor(Visitor visitor){
		int resultCount=0;
		String sql="INSERT INTO visitor VALUES(?,?,?,?,?,?)";
		Connection connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, visitor.getName());
			preparedStatement.setString(3, visitor.getEmail());
			preparedStatement.setString(4, visitor.getPhone());
			preparedStatement.setString(5, visitor.getGender());
			preparedStatement.setInt(6, visitor.getAge());

			resultCount=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCount;
	}
	public Visitor getVisitorById(int id){
		String sql="SELECT * FROM visitor WHERE id=?";
		Connection connection=ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(resultSet.getString(2));
				visitor.setEmail(resultSet.getString(3));
				visitor.setPhone(resultSet.getString(4));
				visitor.setGender(resultSet.getString(5));
				visitor.setAge(resultSet.getInt(6));
				return visitor;
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
