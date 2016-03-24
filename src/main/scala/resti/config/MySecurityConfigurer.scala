package resti.config

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.context.annotation.Bean

@EnableWebSecurity // @EnableGlobalMethodSecurity(prePostEnabled = true) // this annotation at here do not take effects, it should add on the Application
class MySecurityConfigurer extends WebSecurityConfigurerAdapter {
  override def configure(builder: AuthenticationManagerBuilder): Unit = {
    builder.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER")
      .and().withUser("admin").password("admin").roles("ADMIN")
      .and().withUser("jack").password("123456").roles("ADMIN")
  }

  override def configure(http: HttpSecurity): Unit = {
    http
      .authorizeRequests()
      .antMatchers("/", "/home", "/webjars/**").permitAll() //pass the static resources /js /css /images 
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .permitAll()
      .and()
      .logout()
      .invalidateHttpSession(true)
      .deleteCookies("JSESSIONID")
      .logoutSuccessUrl("/login")
      .permitAll()
  }

  @Bean
  override def authenticationManagerBean(): AuthenticationManager = {
    super.authenticationManagerBean()
  }

}