package com.salud.config;


import com.salud.utils.ArrayUtil;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingRespectLayoutTitleStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan({"com.salud","WEB-INF"})
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

   private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect(new GroupingRespectLayoutTitleStrategy()));
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        engine.setTemplateEngineMessageSource(messageSource());
        return engine;
    }

    private List<ITemplateResolver> iTemplateResolvers() {

        List<ITemplateResolver> iTemplateResolvers = new ArrayList<>();

        SpringResourceTemplateResolver resolverHtml = new SpringResourceTemplateResolver();
        resolverHtml.setApplicationContext(applicationContext);
        resolverHtml.setPrefix("classpath:/WEB-INF/html/");
        resolverHtml.setCacheable(false);
        resolverHtml.setTemplateMode(TemplateMode.HTML);
        iTemplateResolvers.add(resolverHtml);

        SpringResourceTemplateResolver resolverJs = new SpringResourceTemplateResolver();
        resolverJs.setApplicationContext(applicationContext);
        resolverJs.setPrefix("classpath:/WEB-INF/js/");
        resolverJs.setCacheable(false);
        resolverJs.setTemplateMode(TemplateMode.JAVASCRIPT);
        iTemplateResolvers.add(resolverJs);

        SpringResourceTemplateResolver resolverCss = new SpringResourceTemplateResolver();
        resolverCss.setApplicationContext(applicationContext);
        resolverCss.setPrefix("classpath:/WEB-INF/css/");
        resolverCss.setCacheable(false);
        resolverCss.setTemplateMode(TemplateMode.CSS);
        iTemplateResolvers.add(resolverCss);

        return iTemplateResolvers;
    }


    @Bean
    public List<ViewResolver> viewResolvers() {

        List<ViewResolver> viewResolvers = new ArrayList<>();

        ThymeleafViewResolver resolverHtml = new ThymeleafViewResolver();
        resolverHtml.setTemplateEngine(templateEngine(iTemplateResolvers().get(0)));
        resolverHtml.setContentType("text/html");
        resolverHtml.setCharacterEncoding("UTF-8");
        resolverHtml.setViewNames(ArrayUtil.array("*.html"));
        viewResolvers.add(resolverHtml);

        ThymeleafViewResolver resolverJs = new ThymeleafViewResolver();
        resolverJs.setTemplateEngine(templateEngine(iTemplateResolvers().get(1)));
        resolverJs.setContentType("application/javascript");
        resolverJs.setCharacterEncoding("UTF-8");
        resolverJs.setViewNames(ArrayUtil.array("*.js"));
        viewResolvers.add(resolverJs);

        ThymeleafViewResolver resolverCss = new ThymeleafViewResolver();
        resolverCss.setTemplateEngine(templateEngine(iTemplateResolvers().get(2)));
        resolverCss.setContentType("application/css");
        resolverCss.setCharacterEncoding("UTF-8");
        resolverCss.setViewNames(ArrayUtil.array("*.css"));
        viewResolvers.add(resolverCss);

        return viewResolvers;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //Html
        registry.addResourceHandler("/html/**").addResourceLocations("classpath:/WEB-INF/html/")
                .resourceChain(true).addResolver(new PathResourceResolver());

        //Css
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/WEB-INF/css/")
                .resourceChain(true).addResolver(new PathResourceResolver());

        //Js
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/WEB-INF/js/")
                .resourceChain(true).addResolver(new PathResourceResolver());

        //Img
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/WEB-INF/img/")
                .resourceChain(true).addResolver(new PathResourceResolver());

        // Icons
        registry.addResourceHandler("/icons/**").addResourceLocations("classpath:/WEB-INF/icons/")
                .resourceChain(true).addResolver(new PathResourceResolver());

        // Swagger
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    // Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/WEB-INF/html/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        return templateResolver;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolverEs() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("es"));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }


}
