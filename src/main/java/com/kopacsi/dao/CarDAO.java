package com.kopacsi.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.kopacsi.entities.CarEntity;

public class CarDAO {

	private static final String CAR_ID = "carId";

	public List<CarEntity> listCars() {
		Session session = SessionUtil.getSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
		Root<CarEntity> c = cq.from(CarEntity.class);
		cq.select(c);

		TypedQuery<CarEntity> query = session.createQuery(cq);
		List<CarEntity> result = query.getResultList();

		session.close();
		return result;
	}
	
	public CarEntity getCarDetails(Integer carId) {
		Session session = SessionUtil.getSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
		Root<CarEntity> c = cq.from(CarEntity.class);
		
		Predicate p1 = cb.equal(c.get(CAR_ID), carId);
		
		cq.where(p1);
		
		cq.select(c);

		TypedQuery<CarEntity> query = session.createQuery(cq);
		CarEntity result = query.getSingleResult();

		session.close();
		return result;
	}

}
