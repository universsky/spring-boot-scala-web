package resti.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import resti.domain.HttpApi
import resti.service.HttpApiRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class UserController {

  @RequestMapping(Array("/login"))
  def login: String = { "/login" }

}