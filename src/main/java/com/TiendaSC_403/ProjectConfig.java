package com.TiendaSC_403;


import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    /* Los siguientes métodos son para incorporar el tema de internacionalización en el proyecto */
    
    /* localeResolver se utiliza para crear una sesión de cambio de idioma */
    @Bean
    public LocaleResolver localeResolver() {
        //crear un objeto de tipo SLR, que va a manerja internamente cual es al 
        //locazacon que tenemos nosotros
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        
        return slr;
    }
    
    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        //va a estar atento cuando se cambie el lenguaje
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");//tiene que calzar con el lang que se encuentra en plantilla
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addInte: registra el intereptor para saber cuando qe va a ambiar de idioma
        registry.addInterceptor(localeChangeInterceptor());
    }
    
    //Bean para poder acceder a los Messages.properties en código...
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        //UTF por si hay ` o ñ
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
}
