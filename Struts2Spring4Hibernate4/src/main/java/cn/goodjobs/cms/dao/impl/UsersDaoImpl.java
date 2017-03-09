package cn.goodjobs.cms.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.goodjobs.cms.dao.UsersDao;
import cn.goodjobs.cms.domain.Users;

@Repository
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	 private Session getCurrentSession() {  
	       return sessionFactory.getCurrentSession(); 
	 }
	 
	
	@Override
	public Long insert(Users users){
		return (Long)this.getCurrentSession().save(users);
	}

	@Override
	public Long update(Users users){
		this.getCurrentSession().update(users);
		return 1L;
	}

	@Override
	public Long delete(Long id){
		this.getCurrentSession().delete(new Users(id));
		return 1L;
	}

	@Override
	public Users getUser(Long id){
		return (Users)this.getCurrentSession().get(Users.class, id);
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsersList(Users users){	
		String hql = "from Users where 1 = 1";
		if(users.getId() != null){
			hql += " and id = :id";
		}
		if(StringUtils.isNotBlank(users.getName())){
			hql += " and name like :name";
		}
		if(StringUtils.isNotBlank(users.getPass())){
			hql += " and pass = :pass";
		}
		if(users.getAge() != null){
			hql += " and age = :age";

		}
		if(users.getShengao() != null){
			hql += " and shengao = :shengao";

		}
		if(StringUtils.isNotBlank(users.getSex())){
			hql += " and sex = :sex";
		}	
		if(users.getWeight() != null){
			hql += " and weight = :weight";
		}	
		if(StringUtils.isNotBlank(users.getNation())){
			hql += " and nation = :nation";
		}	
		if(users.getHobby() != null){
			hql += " and hobby = :hobby";
		}
		Query query = this.currentSession().createQuery(hql);
		
		if(users.getId() != null){
			query.setLong("id", users.getId());
		}
		if(StringUtils.isNotBlank(users.getName())){
			query.setString("name", "%"+users.getName()+"%");
		}
		if(StringUtils.isNotBlank(users.getPass())){
			query.setString("pass", users.getPass());
		}
		if(users.getAge() != null){
			query.setInteger("age", users.getAge());


		}
		if(StringUtils.isNotBlank(users.getSex())){
			query.setString("sex", users.getSex());


		}	
		if(users.getWeight() != null){
			query.setInteger("weight", users.getWeight());
		}	
		if(StringUtils.isNotBlank(users.getNation())){
			query.setString("nation", users.getNation());

		}
			
		if(users.getShengao() != null){
			query.setInteger("shengao", users.getShengao());


		}
		if(users.getHobby() != null){
			query.setString("hobby", users.getHobby());


		}
		List<Users> usersList = (List<Users>)query.list();
		return usersList;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public int getUsersCount(Users users) {
		Criteria c = this.getCurrentSession().createCriteria(Users.class);
		if(users.getId() != null){
			c.add(Restrictions.eq("id", users.getId()));
		}
		if(StringUtils.isNotBlank(users.getName())){
			c.add(Restrictions.like("name", users.getName(),MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(users.getPass())){
			c.add(Restrictions.eq("pass", users.getPass()));
		}
		if(users.getAge() != null){
			c.add(Restrictions.eq("age", users.getAge()));

		}
		if(StringUtils.isNotBlank(users.getSex())){
			c.add(Restrictions.eq("sex", users.getSex()));

		}	
		if(users.getWeight() != null){
			c.add(Restrictions.eq("weight", users.getWeight()));
		}	
		if(StringUtils.isNotBlank(users.getHobby())){
			c.add(Restrictions.eq("hobby", users.getHobby()));
			
		}
		if(StringUtils.isNotBlank(users.getNation())){
			c.add(Restrictions.eq("nation", users.getNation()));
			
		}
		if(users.getShengao() != null){
			c.add(Restrictions.eq("shengao", users.getShengao()));
		}	
		List<Users> list = (List<Users>)c.list();
		if(list != null && list.size() > 0){
			return list.size();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsersPaginatedList(Users users, int first, int count) {
		Criteria c = this.getCurrentSession().createCriteria(Users.class);
		if(users.getId() != null){
			c.add(Restrictions.eq("id", users.getId()));
		}
		if(StringUtils.isNotBlank(users.getName())){
			c.add(Restrictions.like("name", users.getName(),MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(users.getPass())){
			c.add(Restrictions.eq("pass", users.getPass()));
		}
		if(users.getAge() != null){
			c.add(Restrictions.eq("age", users.getAge()));
		}
		if(StringUtils.isNotBlank(users.getSex())){
			c.add(Restrictions.eq("sex", users.getSex()));
		}	
		if(users.getAge() != null){
			c.add(Restrictions.eq("age", users.getAge()));
		}	

		if(users.getWeight() != null){
			c.add(Restrictions.eq("weight", users.getWeight()));
		}	
		if(StringUtils.isNotBlank(users.getNation())){
			c.add(Restrictions.eq("nation", users.getNation()));
		}
		if(users.getShengao() != null){
			c.add(Restrictions.eq("shengao", users.getShengao()));
		}	
		if(StringUtils.isNotBlank(users.getHobby())){
			c.add(Restrictions.eq("hobby", users.getHobby()));
		}
		
		c.setFirstResult(first);//��椤垫�ヨ�㈣捣濮�浣�缃�
		c.setMaxResults(count);//姣�娆℃�ヨ�㈠�灏��＄邯褰�

		return (List<Users>)c.list();

	}
}