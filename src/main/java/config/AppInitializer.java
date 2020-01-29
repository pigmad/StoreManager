package config;


import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author laste
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
            return new Class[] { PersistenceJPAConfig.class };
            //return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
            return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
            return new String[] { "/" };
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); 
        if(!done) throw new RuntimeException();
    }
 
}