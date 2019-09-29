package com.louquanapp.dao.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author 胡化敏
 * @Description: Spring Druid 链接配置
 * @Date Create 2017/11/9 21:49
 * @Modified By:
 * @since: 1.0
 */
@Configuration
@PropertySource("classpath:config/app.properties")
public class DataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 必须加上static
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer loadProperties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

    /**
     * 设置慢sql 过滤器
     *
     * @return
     */
    @Bean
    public Filter statFilter() {
        //具体参考https://github.com/alibaba/druid/wiki/配置_StatFilter
        //Druid内置提供一个StatFilter，用于统计监控信息
        //StatFilter的别名是stat，这个别名映射配置信息保存在druid-xxx.jar!/META-INF/druid-filter.properties。
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(2000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    /**
     * 阿里巴巴 druid 数据源配置
     * https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98
     *
     * @return
     * @throws SQLException
     */
    @Primary
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        //-----------start https://github.com/alibaba/druid/wiki/配置_DruidDataSource参考配置-----------
        //-----------基本配置-----------
        //驱动 链接地址 用户名 密码 设置
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //dataSource.setConnectProperties("config.decrypt=true");


        dataSource.setProxyFilters(Arrays.asList(statFilter()));
        //-----------初始化配置-----------
        // 初始化大小、最小、最大
        dataSource.setInitialSize(20);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(100);

        //配置获取连接等待超时的时间
        dataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒

        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("select 'x' ");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setRemoveAbandonedTimeout(180);
        dataSource.setRemoveAbandoned(true);
        //打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(20);
        dataSource.setProxyFilters(Arrays.asList(statFilter()));
        dataSource.setConnectionErrorRetryAttempts(5);

        //配置监控统计拦截的filters
        dataSource.setFilters("stat");
        //-----------start https://github.com/alibaba/druid/wiki/配置_DruidDataSource参考配置-----------

        return dataSource;
    }

}
