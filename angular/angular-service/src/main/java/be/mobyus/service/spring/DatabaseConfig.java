package be.mobyus.service.spring;

import be.mobyus.service.support.H2IsolationLevelInitializerBean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpShutdownForce");
    }

    @Bean(initMethod = "setIsolationLevelReadUncommited")
    public H2IsolationLevelInitializerBean h2IsolationLevelInitializerBean(DataSource dataSource) {
        return new H2IsolationLevelInitializerBean(dataSource);
    }

    @Bean
    @DependsOn("h2Server")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/mem:introduction-e2e-db");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}
