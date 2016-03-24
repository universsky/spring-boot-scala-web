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
@RequestMapping(Array("/product"))
class ProductController @Autowired() (private val httpApiRepository: HttpApiRepository) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) = {
    // get current user
    val userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal().asInstanceOf[UserDetails]
    model.addAttribute("currentUser", userDetails.getUsername)
    
    model.addAttribute("products", httpApiRepository.findProducts())
    "product/list"
  }

}