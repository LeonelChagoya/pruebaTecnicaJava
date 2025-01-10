package com.java.infrastructure.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Bean
    public DataSource dataSource() {
        return new PooledDataSource(
                "oracle.jdbc.driver.OracleDriver",
                "jdbc:oracle:thin:@localhost:1521/XEPDB1",
                "sys as sysdba",
                "pass1234"
        );
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.java.domain.model");

        org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
        myBatisConfig.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(myBatisConfig);

        return sessionFactory.getObject();
    }
}
