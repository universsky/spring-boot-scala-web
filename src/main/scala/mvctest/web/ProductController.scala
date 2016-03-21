package mvctest.web

import java.lang.Long
import javax.validation.Valid
import mvctest.domain.Hotel
import mvctest.service.HotelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{ PathVariable, RequestMapping, RequestMethod }
import mvctest.service.HttpApiRepository
import mvctest.domain.HttpApi

@Controller
@RequestMapping(Array("/product"))
class ProductController @Autowired() (private val httpApiRepository: HttpApiRepository) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) = {
    model.addAttribute("products", httpApiRepository.findProducts())
    "product/list"
  }

}