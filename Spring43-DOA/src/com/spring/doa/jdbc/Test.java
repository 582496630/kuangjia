package com.spring.doa.jdbc;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	private static Logger logger = Logger.getLogger(Test.class);
	private JdbcTemplate jdbcTemplate;
	private ApplicationContext ctx;

	public void init() {
		//两个xml文件，不同的写法，引用哪个都可以
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		this.jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
	}

	public int insert(Users users) {
		String sql = "insert into user (name,pass) value('" + users.getName() + "','" + users.getPass() + "')";
		int count = this.jdbcTemplate.update(sql);
		return count;
	}

	public int update(Users users) {
		String sql = "update user set name=?,pass=? where id=?";
		int count = this.jdbcTemplate.update(sql, users.getName(), users.getPass(), users.getId());
		return count;
	}

	public int delete(Long id) {
		String sql = "delete from user where id=?";
		int count = this.jdbcTemplate.update(sql, id);
		return count;
	}

	public Users getOne(Long id) {
		String sql = "select * from user where id=" + id;
		Users users = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class));
		return users;
	}

	public Long getCount() {
		// public Long getCount(String name){ 在4.3.3中已经遗弃了这个方法
		String sql = "select count(*) from user";
		return this.jdbcTemplate.queryForObject(sql, Long.class);
		// return this.jdbcTemplate.queryForLongt(sql, name);在4.3.3中已经遗弃了这个方法
	}

	public List<Users> getUsersList() {
		String sql = "select * from user";
		List<Users> uList = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
		return uList;
	}

	public List<Users> getUsersList(Users users) {
		//where后面的1=1 是恒真的条件，防止后面的其它条件不成立时，sql语句的where后面没有条件，这样程序就会报错
		//有恒真的条件后，即使其它条件不成立，程序也会正常输出，只是是输出全部的表，没有安装条件（因为条件不成立）
		String sql = "select * from user where 1=1 and name=? and pass = ?";
		List<Users> uList = this.jdbcTemplate.query(sql, new Object[] { users.getName(), users.getPass() },
				new BeanPropertyRowMapper<Users>(Users.class));
		return uList;
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.init();

		Users users = new Users();
		// users.setId(3L);
		 users.setName("shisu01");
		 users.setPass("12345222");
		 logger.info(test.insert(users));//添加输入到表内
		// logger.info(test.update(users));//更改表内的数据
		// logger.info(test.delete(5L)); //删除id为5的数据

		// 只获取id=1的数据
		// Users users = test.getOne(1L);
		// logger.info(users);

		// 输出数据库表内整个数据
		// List<Users> uList = test.getUsersList();
		// logger.info(uList);

		// 依照给的参数来输出数据
		// List<Users> ulist = test.getUsersList(users);
		// logger.info(ulist);

		// logger.info(test.getCount("zhangsan")); 在4.3.3中已经遗弃了这个方法
		// logger.info(test.getCount()); //获取数据库表有多少数据

		// 依照给的参数来输出数据
		/*
		 * List<Users> userslist=test.getUsersList(users);
		 * logger.info(userslist.size()); //遍历数据 for(Users users2 : userslist){
		 * logger.info(users2); }
		 * 
		 */

	}

}
