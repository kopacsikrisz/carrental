package com.kopacsi.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kopacsi.entities.BookingEntity;

public class BookingDAO {

	private static final String BOOKING_DATE_TO = "bookingDateTo";
	private static final String BOOKING_DATE_FROM = "bookingDateFrom";

	public BookingEntity persist(BookingEntity entity) {

		Session session = SessionUtil.getSession();

		Transaction tx = session.beginTransaction();

		session.save(entity);

		tx.commit();
		session.close();

		return entity;
	}

	public List<BookingEntity> bookingsForInterval(LocalDate from, LocalDate to) {
		Session session = SessionUtil.getSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();

		CriteriaQuery<BookingEntity> cq = cb.createQuery(BookingEntity.class);
		Root<BookingEntity> c = cq.from(BookingEntity.class);

		List<Predicate> predicateList = new ArrayList<>();

		Predicate p1 = cb.lessThan(c.get(BOOKING_DATE_FROM), to);
		Predicate p2 = cb.greaterThan(c.get(BOOKING_DATE_TO), from);

		predicateList.add(p1);
		predicateList.add(p2);

		cq.where(cb.and(predicateList.toArray(new Predicate[0])));

		cq.select(c);

		TypedQuery<BookingEntity> query = session.createQuery(cq);
		List<BookingEntity> result = query.getResultList();

		session.close();
		return result;
	}

}
