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
	
	/*��ȡsesion
	@return*/
	public Session getSession(){
		sessionFactory =new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		return session;
	}
	
	//�ر�session
	public void closeSession(){
		if(session !=null)
			session.close();
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	//��������
	public Long insert(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//��ʼ����
		Long id = (Long) session.save(users);//�����
		transaction.commit();
		closeSession();
		return id;
	}
	//��������
	public void update(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//��ʼ����
		session.update(users);
		transaction.commit();
		closeSession();
	}
	//ɾ��������
	public void delete(Users users){
		session =getSession();
		Transaction transaction = session.beginTransaction();//��ʼ����
		session.delete(users);
		transaction.commit();
		closeSession();
	}
	//��ȡ��һ������
	public Users getUsersById(Long id){
		session =getSession();
		Users users =(Users)session.get(Users.class, id);
		closeSession();
		return users;
	}
	//��ȡ�б�
	@SuppressWarnings("unchecked")
	public List<Users> getUsersList(){
		session = getSession();
		List<Users> usersList = (List<Users>)session.createQuery("from Users").getResultList();
		closeSession();
		return usersList;
	}
	public static void main(String[] args){
		UsersTest test = new UsersTest();
		//�����ݿ�����һ�����ݣ�id����������
		Long userId = test.insert(new Users(7L,"jack11","jack"));
	   logger.info(userId);
		logger.info(test.getUsersById(userId));
		
		//�޸�id=4 �ĵ�����
		//test.update(new Users(4L,"tom","to2m"));
		
		//ɾ��id=9 ������
		//Users users = new Users();
		//users.setId(9L);
		//test.delete(users);
		
		//����Id��ȡid=5������
		// logger.info(test.getUsersById(10L));
		
		//�������ݱ��ڵ���������
		/*List<Users> usersList = test.getUsersList();
		for(Users users1 : usersList){
			logger.info(users1);
		}*/
	}
}
