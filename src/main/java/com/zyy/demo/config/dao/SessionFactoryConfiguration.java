package com.zyy.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

//做事务的提交   将datasource 跟 mybatis 绑定在一起, 支持事务的SqlSessionFactory
@Configuration
public class SessionFactoryConfiguration {

    //设置mybatis-config的配置文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    //实现DAO层，实现ORM的作用，调用jdbc
    @Value("${mapper_path}")
    private String mapperPath;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    //指定实体类package的扫描路径
    @Value("${entiy_package}")
    private String entityPackage;

    @Bean(name="SqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();//加载文件路径
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        return sqlSessionFactoryBean;
    }
}
