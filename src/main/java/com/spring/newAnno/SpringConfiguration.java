package com.spring.newAnno;

import com.kuiniu.jdbc.JDBCUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.spring"})
@Import(JDBCUtils.class)
public class SpringConfiguration {

}
