package com.github.binarywang.demo.wechat.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setProxyFilters(Arrays.asList(statFilter()));
        return ds;
    }

    @Bean
    public Filter statFilter() {
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }
}