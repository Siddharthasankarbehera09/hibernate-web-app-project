package org.framework.userwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.framework.userwebapp.dto.User;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	public User saveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User updateUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(user);
		transaction.begin();
		transaction.commit();
		return user;
	}

	public User getUserById(int id) {
		return manager.find(User.class, id);
	}

	public boolean deleteUserById(int id) {
		User u = getUserById(id);
		if (u != null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

	public User verifyUser(long phone, String password) {
		String hql = "select u from User u where u.phone=?1 and u.password=?2";
		Query q = manager.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		List<User> users = q.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
