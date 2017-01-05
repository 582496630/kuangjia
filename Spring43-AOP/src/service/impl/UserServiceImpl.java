package service.impl;

import dao.UserDao;

import entity.User;
import lombok.Setter;
import service.UserService;
@Setter
public class UserServiceImpl implements UserService {

	private UserDao dao;
	
	
	@Override
	public void addNewUser(User user) {
		// TODO Auto-generated method stub
		
		dao.save(user);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
