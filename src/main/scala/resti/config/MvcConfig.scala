package resti.config

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.context.annotation.Configuration

@Configuration
class MvcConfig extends WebMvcConfigurerAdapter {
  override def addViewControllers(registry: ViewControllerRegistry) {
    //registry.addViewController("/home").setViewName("home");
    //registry.addViewController("/login").setViewName("login");
  }
}