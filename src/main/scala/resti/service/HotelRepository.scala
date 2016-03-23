package resti.service

import org.springframework.data.repository.CrudRepository
import resti.domain.Hotel
import java.lang.Long

trait HotelRepository extends CrudRepository[Hotel, Long]