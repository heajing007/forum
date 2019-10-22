package cn.test.forum.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc  //如果要使用springboot自动配置，那么就不能加上@EnableWebMvc注解,否则excludePathPatterns全部失效
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private  SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/index","/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/bootstrap3/**");
    }
}