package resti.service

import java.lang.Long

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

import javax.persistence.Persistence
import resti.domain.HttpApi

trait HttpApiRepository extends PagingAndSortingRepository[HttpApi, Long] {
  @Query(value = "SELECT distinct product FROM http_api", nativeQuery = true)
  def findProducts(): java.util.List[String]
}