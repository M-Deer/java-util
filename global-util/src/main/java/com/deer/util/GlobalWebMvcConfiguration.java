package com.deer.util;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GlobalWebMvcConfiguration
 * @Author: Mr_Deer
 * @Date: 2019/5/5 12:06
 * @Description: 配置全局的 SpringMVC 配置项
 */
public class GlobalWebMvcConfiguration implements WebMvcConfigurer {

    // 允许跨域访问的域名
    private static final String[] ORIGINS = {"http://localhost:80", "http://localhost:81", "http://localhost:8080"};

    /**
     * 使用 FastJson 作为默认的 json 解析
     *
     * @param converters converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        // 处理中文乱码的问题
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setFastJsonConfig(jsonConfig);
        converters.add(converter);
    }


    /**
     * 设置路由跳转的配置
     * 这种设置就不需要为页面单开一个 Controller 了
     * 因为大部分时候都是用的 RestFul
     *
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/路由地址").setViewName("具体的页面位置");
    }

    /**
     * 跨域配置
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域的路径，这里是通配所有
        registry.addMapping("/**")
                // 允许跨域访问的域名
                .allowedOrigins(ORIGINS)
                // 是否允许证书，不再默认开启
                .allowCredentials(true)
                // 允许的方法
                .allowedMethods("*")
                // 允许的时间
                .maxAge(3600);
    }
}
