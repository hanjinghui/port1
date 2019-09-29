package com.louquanapp.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.louquanapp.model.WxPayProperties;
import com.louquanapp.web.exception.HuhuaminExceptionHandler;
import com.louquanapp.web.interceptor.InviteInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2019年03月26日15:19:13
 * @Modified By:
 * @Since:
 */
@Configuration
@EnableWebMvc
//@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.louquanapp")
public class WebConfig extends WebMvcConfigurerAdapter {
    //    private final static String preFix = "/WEB-INF/pages/";
    private static Map<String, String> mapResource = new HashMap<>();
    private static List<MediaType> supportedMediaTypes = new ArrayList<>();

    static {
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
    }
    //html 支持

    static {
        mapResource.put("/web/css/**", "/WEB-INF/web/css/");
        mapResource.put("/web/image/**", "/WEB-INF/web/image/");
        mapResource.put("/web/js/**", "/WEB-INF/web/js/");
        mapResource.put("/web/**", "/WEB-INF/web/");
        mapResource.put("/video/**", "/WEB-INF/video/");
        mapResource.put("/favicon.ico", "/favicon.ico");

        mapResource.put("/web8/css/**", "/WEB-INF/web8/css/");
        mapResource.put("/web8/images/**", "/WEB-INF/web8/images/");
        mapResource.put("/web8/js/**", "/WEB-INF/web8/js/");
        mapResource.put("/web8/**", "/WEB-INF/web8/");


    }


//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix(preFix);
//        viewResolver.setSuffix(".jsp");
//
//        //viewResolver.setExposeContextBeansAsAttributes(true);
//        return viewResolver;
//    }

    //文件上传，bean必须写name属性且必须为multipartResolver，不然取不到文件对象，别问我为什么，我也唔知
    @Bean(name = "multipartResolver")
    protected CommonsMultipartResolver MultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //multipartResolver.setUploadTempDir(new FileSystemResource("/tmp"));//可不设置
        multipartResolver.setMaxUploadSize(3000000);//3M
        multipartResolver.setMaxInMemorySize(0);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }


    @Bean
    @Qualifier("exceptionHandler")
    public HuhuaminExceptionHandler exceptionHandler() {
        return new HuhuaminExceptionHandler();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(crossInterceptor()).addPathPatterns("/**");
//    }

//      跨域支持
//    @Bean
//    public CrossInterceptor crossInterceptor() {
//        return new CrossInterceptor();
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(inviteInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public InviteInterceptor inviteInterceptor() {
        return new InviteInterceptor();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for (String key :
                mapResource.keySet()) {
            registry.addResourceHandler(key).addResourceLocations(mapResource.get(key));

        }

    }

    //@EnableWebMvc==>DelegatingWebMvcConfiguration==>WebMvcConfigurationSupport==>configureMessageConverters
    //setContentNegotiationManager
    //参考逻辑
//    protected final List<HttpMessageConverter<?>> getMessageConverters() {
//        if (this.messageConverters == null) {
//            this.messageConverters = new ArrayList();
//            this.configureMessageConverters(this.messageConverters); //我们这里webconfig 配置了自动了fastjson解析器
//            if (this.messageConverters.isEmpty()) {
//                this.addDefaultHttpMessageConverters(this.messageConverters); //若果没有自定义的 使用默认的
//            }
//
//            this.extendMessageConverters(this.messageConverters);
//        }
//
//        return this.messageConverters;
//    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        SerializerFeature[] featureXX = new SerializerFeature[]{SerializerFeature.BrowserSecure, SerializerFeature.DisableCircularReferenceDetect};
        config.setSerializerFeatures(featureXX);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(config);

        converter.setSupportedMediaTypes(supportedMediaTypes);

        converters.add(converter);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    public RestTemplate restTemplate() {
        RestTemplate temp = new RestTemplate();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        SerializerFeature[] featureXX = new SerializerFeature[]{SerializerFeature.BrowserSecure, SerializerFeature.DisableCircularReferenceDetect};
        config.setSerializerFeatures(featureXX);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(config);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(converter);
        temp.setMessageConverters(converters);

        return temp;
    }

    //定时器
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setJobFactory(myJobFactory());
//        return schedulerFactoryBean;
//    }

//    @Bean
//    public MyJobFactory myJobFactory() {
//        return new MyJobFactory();
//    }


    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("39.100.99.80");
        redisManager.setPort(6379);
        redisManager.setExpire(36000);// 配置缓存过期时间
        redisManager.setTimeout(0);
        redisManager.setPassword("SUZONG@559841");


//        redisManager.setPassword("HUHUAMIN@423177");

        return redisManager;
    }


    /**
     * 初始化方法
     */
    @Bean
    public JedisPool jedisPool() {
        RedisManager redisManager = redisManager();

        if (redisManager.getPassword() != null && !"".equals(redisManager.getPassword())) {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort(), redisManager.getTimeout(), redisManager.getPassword());
        } else if (redisManager.getTimeout() != 0) {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort(), redisManager.getTimeout());
        } else {
            return new JedisPool(new JedisPoolConfig(), redisManager.getHost(), redisManager.getPort());
        }

    }

    private WxPayProperties properties;

    @Autowired
    public WebConfig(WxPayProperties properties) {
        this.properties = properties;
    }

    @Bean
    public WxPayService wxService() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(StringUtils.trimToNull(this.properties.getAppId()));
        payConfig.setMchId(StringUtils.trimToNull(this.properties.getMchId()));
        payConfig.setMchKey(StringUtils.trimToNull(this.properties.getMchKey()));
        payConfig.setSubAppId(StringUtils.trimToNull(this.properties.getSubAppId()));
        payConfig.setSubMchId(StringUtils.trimToNull(this.properties.getSubMchId()));
        payConfig.setKeyPath(StringUtils.trimToNull(this.properties.getKeyPath()));

        // 可以指定是否使用沙箱环境
        payConfig.setUseSandboxEnv(false);

        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

}


