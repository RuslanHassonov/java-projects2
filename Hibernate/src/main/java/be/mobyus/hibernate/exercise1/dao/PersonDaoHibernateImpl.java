package be.mobyus.hibernate.exercise1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.mobyus.hibernate.exercise1.AddressSearchCriteria;
import be.mobyus.hibernate.exercise1.entities.Person;

@Repository
@Transactional
@Profile("hibernate")
public class PersonDaoHibernateImpl implements PersonDao {

	private SessionFactory sessionFactory;

	@Autowired
	public PersonDaoHibernateImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Person> findAll() {
		// TODO make me work
		return new ArrayList<>();
	}

	@Override
	public List<Person> findByName(String name) {
		// TODO make me work
		return null;
	}

	@Override
	public void removePerson(Person person) {
		// TODO make me work
	}

	@Override
	public void savePerson(Person person) {
		// TODO make me work
	}

	@Override
	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		// TODO make me work
		return new ArrayList<>();
	}
}