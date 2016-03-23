package resti.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ServletContextTemplateResolver
import org.thymeleaf.templateresolver.TemplateResolver

@Configuration
class ThymeleafConfig @Autowired() (private val messageSource: MessageSource,
    private val springSecurityDialect: SpringSecurityDialect) {

  @Bean
  def templateResolver(): TemplateResolver = {
    val templateResolver = new ServletContextTemplateResolver()
    templateResolver.setPrefix("/WEB-INF/views/")
    templateResolver.setSuffix(".html")
    templateResolver.setTemplateMode("HTML5")
    templateResolver.setCharacterEncoding("UTF-8")
    templateResolver.setCacheable(false)
    templateResolver
  }

  @Bean
  def templateEngine(): SpringTemplateEngine = {
    val templateEngine = new SpringTemplateEngine()
    templateEngine.setTemplateResolver(templateResolver())
    templateEngine.setMessageSource(messageSource)
    templateEngine.addDialect(springSecurityDialect)
    templateEngine
  }

  @Bean
  def viewResolver(): ViewResolver = {
    val viewResolver = new ThymeleafViewResolver()
    viewResolver.setTemplateEngine(templateEngine())
    viewResolver.setOrder(1)
    viewResolver.setCharacterEncoding("UTF-8")
    viewResolver
  }

  @Bean
  def securityDialect(): SpringSecurityDialect = {
    new SpringSecurityDialect()
  }

}