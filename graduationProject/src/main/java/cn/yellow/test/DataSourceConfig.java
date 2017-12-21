package cn.yellow.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.dianping.zebra.dao.mybatis.ZebraMapperScannerConfigurer;
import com.dianping.zebra.group.jdbc.GroupDataSource;
import com.dianping.zebra.single.jdbc.SingleDataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Data
@MapperScan(basePackages = "cn.yellow.mappers",sqlSessionFactoryRef = "mybatisSqlSessionFactory")
public class DataSourceConfig {
    private String url;
    private String username;
    private String password;

    //@Value("${zebra.jdbcref}")
    private String jdbcref;

    //@Value("${zebra.pooltype}")
    private String poolType;

    @Bean(name="mybatisDataSource")
    public DataSource mybatisDataSource(){
      DruidDataSource dataSource=new DruidDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mydatabase");
      dataSource.setUsername("root");
      dataSource.setPassword("a19960901");
      return dataSource;
    }
    @Bean
    public DataSource mybatisDataSource2(){
        SingleDataSource singleDataSource=new SingleDataSource();
        singleDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mydatabase?user=root");
        singleDataSource.setDriverClass("com.mysql.jdbc.Driver");
        singleDataSource.setUser("root");
        singleDataSource.setPassword("a19960901");
        singleDataSource.setPoolType("tomcat-jdbc");
        singleDataSource.init();
        return singleDataSource;
    }

    @Bean(name="mybatisSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory()throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mybatisDataSource2());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/Mapper/*Mapper*.xml"));
    sqlSessionFactoryBean.setTypeAliasesPackage("cn.yellow.entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="mysqlTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(mybatisDataSource2());
    }
/*    @Bean(name="zebrab")
    public DataSource dataSource(){
        GroupDataSource dataSource = new GroupDataSource();
        dataSource.setJdbcRef("dianpingcscpacific");
//        <!-- 选配。指定底层使用的连接池类型，支持"c3p0","tomcat-jdbc","druid","hikaricp","dbcp2"和"dbcp"，推荐使用"tomcat-jdbc"，默认值为"c3p0" -->
        dataSource.setPoolType("tomcat-jdbc");
//        <!-- 选配。指定连接池的最小连接数，默认值是5。 -->
        dataSource.setMinPoolSize(5);
//        <!-- 选配。指定连接池的最大连接数，默认值是20。 -->
        dataSource.setMaxPoolSize(20);
//        <!-- 选配。指定连接池的初始化连接数，默认值是5。 -->
        dataSource.setInitialPoolSize(5);
//        <!-- 选配。指定连接池的获取连接的超时时间，默认值是1000。 -->
        dataSource.setCheckoutTimeout(1000);
        dataSource.setMaxIdleTime(1800);
        dataSource.setAcquireRetryAttempts(3);
        dataSource.setIdleConnectionTestPeriod(60);
        dataSource.setAcquireRetryDelay(300);
        dataSource.setMaxStatements(0);
        dataSource.setMaxStatementsPerConnection(100);
        dataSource.setNumHelperThreads(6);
        dataSource.setMaxAdministrativeTaskTime(5);
        dataSource.setPreferredTestQuery("SELECT 1");
        dataSource.init();
        return dataSource;
    }*/
    @Bean
    public ZebraMapperScannerConfigurer zebraMapperScannerConfigurer(){
        ZebraMapperScannerConfigurer zebraMapperScannerConfigurer=new ZebraMapperScannerConfigurer();
        zebraMapperScannerConfigurer.setBasePackage("cn.yellow.mappers");
        zebraMapperScannerConfigurer.setMaxPoolSize("200");
        zebraMapperScannerConfigurer.setCorePoolSize("20");
        zebraMapperScannerConfigurer.setQueueSize("500");
        zebraMapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatisSqlSessionFactory");
        return zebraMapperScannerConfigurer;
    }
}
