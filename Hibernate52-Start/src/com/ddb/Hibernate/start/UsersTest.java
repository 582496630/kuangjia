package com.ddb.Hibernate.start;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UsersTest {
	private static final Logger logger=Logger.getLogger(UsersTest.class);
	private Session session = null;
	private SessionFactory sessionFactory =null;
	
	/*获取sesion
	@return*/
	public Session getSession(){
		sessionFactory =new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		return session;
	}
	
	//关闭session
	public void closeSession(){
		if(session !=null)
			session.close();
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	//插入数据
	public Long insert(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//开始事务
		Long id = (Long) session.save(users);//保存表
		transaction.commit();
		closeSession();
		return id;
	}
	//更新数据
	public void update(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//开始事务
		session.update(users);
		transaction.commit();
		closeSession();
	}
	//删除表数据
	public void delete(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//开始事务
		session.delete(users);
		transaction.commit();
		closeSession();
	}
	//获取第一条数据
	public Users getUsersById(Long id){
		session =getSession();
		Users users =(Users)session.get(Users.class, id);
		closeSession();
		return users;
	}
	//获取列表
	@SuppressWarnings("unchecked")
	public List<Users> getUsersList(){
		session = getSession();
		List<Users> usersList = (List<Users>)session.createQuery("from Users").getResultList();
		closeSession();
		return usersList;
	}
	public static void main(String[] args){
		UsersTest test = new UsersTest();
		//向数据库增加一条内容，id是自增长的
		Long userId = test.insert(new Users(7L,"jack11","jack"));
	   logger.info(userId);
		logger.info(test.getUsersById(userId));
		
		//修改id=4 的的数据
		//test.update(new Users(4L,"tom","to2m"));
		
		//删除id=9 的数据
		//Users users = new Users();
		//users.setId(9L);
		//test.delete(users);
		
		//根据Id获取id=5的内容
		// logger.info(test.getUsersById(10L));
		
		//遍历数据表内的数据内容
		/*List<Users> usersList = test.getUsersList();
		for(Users users1 : usersList){
			logger.info(users1);
		}*/
	}
}
