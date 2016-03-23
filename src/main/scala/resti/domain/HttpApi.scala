package resti.domain

import javax.persistence.Id
import javax.persistence.GeneratedValue
import java.lang.Long
import javax.persistence.Entity
import scala.beans.BeanProperty
import org.hibernate.validator.constraints.NotEmpty

@Entity
class HttpApi {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @NotEmpty
  var product: String = _

  @BeanProperty
  @NotEmpty
  var module: String = _

  @BeanProperty
  @NotEmpty
  var name: String = _

  @BeanProperty
  @NotEmpty
  var uri: String = _

  @BeanProperty
  @NotEmpty
  var host: String = _

  @BeanProperty
  @NotEmpty
  var paramsType: String = _ // 'json'  'header'  'form'  'body'

  @BeanProperty
  var paramsContent: String = _ // json string

  @BeanProperty
  var expectOutput: String = _

  @BeanProperty
  var actualOutput: String = _

  @BeanProperty
  var result: String = _ // Pass Fail Not_Implemented
}