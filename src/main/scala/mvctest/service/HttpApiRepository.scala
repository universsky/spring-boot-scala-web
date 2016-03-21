package mvctest.service

import java.lang.Long

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

import javax.persistence.Persistence
import mvctest.domain.HttpApi

trait HttpApiRepository extends PagingAndSortingRepository[HttpApi, Long] {
  @Query(value = "SELECT distinct product FROM hotel.http_api limit 1", nativeQuery = true)
  def findProducts(): String
}