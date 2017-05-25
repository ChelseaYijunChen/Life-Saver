/**
 * 
 */
package com.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Absent;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 11:19:42 PM
 */
@Repository("absentDao")
@Transactional
public class AbsentDaoImpl implements AbsentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addAbsent(Absent absent) {
		sessionFactory.getCurrentSession().save(absent);
		System.out.println("add absent sucess");
	}

	// @Override
	public void deleteAbsent(Integer absentId) {
		Absent absent = (Absent) sessionFactory.getCurrentSession().load(Absent.class, absentId);
		if (null != absent) {
			this.sessionFactory.getCurrentSession().delete(absent);
		}
	}

	// @Override
	public void updateAbsent(Absent absent) {
		sessionFactory.getCurrentSession().update(absent);
		System.out.println("update absent sucess");

	}

	// @Override
	public Absent viewAbsentById(Integer absentId) {
		Absent absent = (Absent) sessionFactory.getCurrentSession().load(Absent.class, absentId);
		return absent;
	}

	// @Override
	public List<Absent> viewAllAbsents() {
		return this.sessionFactory.getCurrentSession().createQuery("from Absent").getResultList();
		// return (List<Absent>)
		// sessionFactory.getCurrentSession().createCriteria(Absent.class).list();
	}

	// @Override
	public List<Absent> viewAbsentByDoctorId(Integer doctorId) {
		List<Absent> absent = sessionFactory.getCurrentSession()
				.createQuery("FROM Absent WHERE doctor = '" + doctorId + "'").getResultList();
		if (absent == null || absent.size() == 0) {
			return null;
		} else {
			return absent;
		}
	}

	public List<Absent> viewApprovedAbsents() {
		return this.sessionFactory.getCurrentSession().createQuery("from Absent where isApproved = 'Yes'").getResultList();
	}

	public List<Absent> viewAbsentsNeedToApprove() {
		return this.sessionFactory.getCurrentSession().createQuery("from Absent where isApproved = 'No'").getResultList();
	}
}
