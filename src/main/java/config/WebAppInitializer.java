package config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SocialConfig.class, SecurityConfig.class, RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        
        return new String[]{
                "/"
        };
    }

 
 }