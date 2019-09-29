package com.louquanapp.dao.config;

import com.github.pagehelper.PageInterceptor;
import com.louquanapp.dao.interceptor.MapF2FInterceptor;
import org.apache.ibatis.executor.loader.cglib.CglibProxyFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/10 17:48
 * @Modified By:
 * @Since:
 */
@Configuration
@MapperScan(basePackages = "com.louquanapp.dao.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
public class MyBatisConfig {
    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    @Lazy(false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        可以设置自定义类型TypeHandlers
//        sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{new TestTypeHandle(),new GPTypeHandler()});
//         设置TypeHandler所在的包
//        sqlSessionFactoryBean.setTypeHandlersPackage("com.gupao.dal.typehandles");
//         设置插件
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new TestPlugin()});
//
        //   设置拦截器
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor(), mapF2FInterceptor()});

        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
        factory.getConfiguration().setLazyLoadingEnabled(true);
        factory.getConfiguration().setAggressiveLazyLoading(false);
        factory.getConfiguration().setProxyFactory(new CglibProxyFactory());
        return factory;
    }

    /**
     * 设置分页参数属性
     * https://github.com/pagehelper/Mybatis-PageHelper/blob/master/README_zh.md
     *
     * @return
     */
    private PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");
        properties.setProperty("reasonable", "false");
        pageInterceptor.setProperties(properties);

        return pageInterceptor;
    }

    private MapF2FInterceptor mapF2FInterceptor() {
        MapF2FInterceptor mapF2FInterceptor = new MapF2FInterceptor();
        return mapF2FInterceptor;

    }

    /**
     * 默认  sqlSessionTemplate
     *
     * @return
     * @throws Exception
     */
    @Primary
    @Lazy(false)
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.SIMPLE);
    }

    /**
     * BATCH SqlSessionTemplate
     *
     * @return
     * @throws Exception
     */
    @Lazy(false)
    @Bean(name = "batchSst")
    public SqlSessionTemplate batchSst() throws Exception {
        return new SqlSessionTemplate(localSessionFactoryBean(), ExecutorType.BATCH);
    }

    /**
     * 事务bean 设置
     *
     * @return
     */
    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
