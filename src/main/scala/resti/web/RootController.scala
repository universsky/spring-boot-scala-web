package resti.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RootController {

  @RequestMapping(Array("/home"))
  def home(): String = "/home"

  @RequestMapping(Array("/"))
  def handleRootRequest(): String = "/home"
}
