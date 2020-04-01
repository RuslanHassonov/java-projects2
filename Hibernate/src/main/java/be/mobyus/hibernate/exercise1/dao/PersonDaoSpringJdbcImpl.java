package be.mobyus.hibernate.exercise1.dao;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.mobyus.hibernate.exercise1.AddressSearchCriteria;
import be.mobyus.hibernate.exercise1.entities.Person;

@Repository
@Transactional
@Profile("jdbc")
public class PersonDaoSpringJdbcImpl extends JdbcTemplate implements PersonDao {

	@Autowired
	public PersonDaoSpringJdbcImpl(DataSource dataSource) {
		super(dataSource);
	}

	public List<Person> findAll() {
		return null;
	}

	public List<Person> findByName(String name) {
		return query("select * from person", new Object[] {}, (rs, rowNum) -> {
			Person person = new Person();
			person.setName(rs.getString("name"));
			return person;
		});
	}

	public void removePerson(Person person) {
		super.update("delete from person where id = ?", new Long[] { person.getId() });
	}

	public void savePerson(Person person) {
		final String qryPerson = "insert into person (name, firstname) values(?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		update(connection -> {
			PreparedStatement ps = connection.prepareStatement(qryPerson, new String[] { "id" });
			ps.setString(1, person.getName());
			ps.setString(2, person.getFirstName());
			return ps;
		}, keyHolder);

		final String qryPersonAddress =
				"insert into person_address (person_id, box, country, housenumber, municipality, postalcode, street) " + "values(?, ?, ?, ?, ?, ?, ?)";

		person.getAddress().forEach(
				a -> update(qryPersonAddress, keyHolder.getKey().longValue(), a.getBox(), a.getCountry(), a.getHouseNumber(), a.getMunicipality(), a.getPostalCode(),
						a.getStreet()));
	}

	@Override
	public List<Person> findByAddress(final AddressSearchCriteria addressSearchCriteria) {
		StringBuilder query = new StringBuilder("select * from person where ");

		StringBuilder criteria = new StringBuilder();

		List<String> parameters = new ArrayList<String>();

		if (isNotBlank(addressSearchCriteria.getBox())) {
			criteria.append(" and upper(box) = ?");
			parameters.add(addressSearchCriteria.getBox().toUpperCase());
		}
		if (isNotBlank(addressSearchCriteria.getHouseNumber())) {
			criteria.append(" and upper(housenumber) = ?");
			parameters.add(addressSearchCriteria.getHouseNumber().toUpperCase());
		}
		if (isNotBlank(addressSearchCriteria.getCountry())) {
			criteria.append(" and upper(country) = ?");
			parameters.add(addressSearchCriteria.getCountry().toUpperCase());
		}
		if (isNotBlank(addressSearchCriteria.getMunicipality())) {
			criteria.append(" and upper(municipality) = ?");
			parameters.add(addressSearchCriteria.getMunicipality().toUpperCase());
		}
		if (isNotBlank(addressSearchCriteria.getStreet())) {
			criteria.append(" and upper(street) = ?");
			parameters.add(addressSearchCriteria.getStreet().toUpperCase());
		}
		if (isNotBlank(addressSearchCriteria.getPostalCode())) {
			criteria.append(" and upper(postalcode) = ?");
			parameters.add(addressSearchCriteria.getPostalCode().toUpperCase());
		}

		query.append(criteria.replace(0, 4, ""));

		return super.query(query.toString(), parameters.toArray(new String[] {}), new RowMapper<Person>() {

			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();

				return person;
			}
		});
	}
}