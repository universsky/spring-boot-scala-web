package mvctest.service

import org.springframework.data.repository.CrudRepository

import javax.persistence.Entity
import mvctest.domain.HttpApi
import java.lang.Long

trait HttpApiRepository extends CrudRepository[HttpApi, Long]