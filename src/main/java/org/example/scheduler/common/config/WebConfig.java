package org.example.scheduler.common.config;

import jakarta.servlet.Filter;
import org.example.scheduler.common.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        // Filter 등록
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        // Filter 순서 설정
        filterFilterRegistrationBean.setOrder(1);
        // 전체 URL 에 Filter 적용
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}
