package com.springcloud.demo.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 数据库连接池配置
 *
 * @Author: yzp
 * @Date: 2020-4-29
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private Integer initialSize = 2;

    private Integer minIdle = 1;

    private Integer maxActive = 20;

    private Integer maxWait = 60000;

    private Integer timeBetweenEvictionRunsMillis = 60000;

    private Integer minEvictableIdleTimeMillis = 300000;

    private String validationQuery = "SELECT 'x'";

    private Boolean testWhileIdle = true;

    private Boolean testOnBorrow = false;

    private Boolean testOnReturn = false;

    private Boolean poolPreparedStatements = true;

    private Integer maxPoolPreparedStatementPerConnectionSize = 20;

    private String filters = "stat";

    public void config(DruidDataSource dataSource) {

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setDriverClassName(driverClassName);
        //定义初始连接数
        dataSource.setInitialSize(initialSize);
        //最小空闲
        dataSource.setMinIdle(minIdle);
        //定义最大连接数
        dataSource.setMaxActive(maxActive);
        //最长等待时间
        dataSource.setMaxWait(maxWait);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        // 配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);

        // 打开PSCache，并且指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
