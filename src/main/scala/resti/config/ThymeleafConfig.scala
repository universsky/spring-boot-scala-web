package resti.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Description
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ServletContextTemplateResolver

import com.typesafe.scalalogging.slf4j.LazyLogging

//@Configuration
class ThymeleafConfig extends LazyLogging {

  @Bean
  @Description("Template resolver serving HTML 5 emails")
  def templateResolver = {
    val templateResolver = new ServletContextTemplateResolver
    templateResolver.setPrefix("classpath:/templates/")
    templateResolver.setSuffix(".html")
    templateResolver.setTemplateMode("HTML5")
    templateResolver.setCharacterEncoding("UTF-8")
    templateResolver.setCacheable(false)
    templateResolver.setOrder(1)
    templateResolver

  }

  @Bean
  @Description("ThymeleafViewResolver")
  def thymeleafViewResolver = {
    val thymeleafViewResolver = new ThymeleafViewResolver
    thymeleafViewResolver.setCharacterEncoding("UTF-8")
    thymeleafViewResolver.setContentType("text/html")
    thymeleafViewResolver.setOrder(2)
    thymeleafViewResolver.setTemplateEngine(new SpringTemplateEngine)
    thymeleafViewResolver

  }

}