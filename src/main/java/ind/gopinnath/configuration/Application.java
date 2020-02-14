package ind.gopinnath.configuration;

import javax.servlet.Servlet;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ind.gopinnath.example.servlet.ExportServlet;

@ComponentScan(basePackages = {"ind.gopinnath.example"})
@EntityScan("ind.gopinnath.example.entity")
@EnableJpaRepositories("ind.gopinnath.example.repository")
@SpringBootApplication(exclude = { DispatcherServletAutoConfiguration.class, ErrorMvcAutoConfiguration.class })
public class Application implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		Application.context = context;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void main(String[] arguements) {
		SpringApplication.run(Application.class, arguements);
	}

	@Bean
	public ServletRegistrationBean<Servlet> myServletRegistration() {
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
		servletRegistrationBean.setServlet(new ExportServlet());
		return servletRegistrationBean;
	}
}
