package be.mobyus.service.support;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class H2IsolationLevelInitializerBean {

    private final JdbcTemplate jdbcTemplate;

    public H2IsolationLevelInitializerBean(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setIsolationLevelReadUncommited() {
        jdbcTemplate.execute("SET LOCK_MODE 0");
    }
}
