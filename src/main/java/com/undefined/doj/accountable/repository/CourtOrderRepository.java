package com.undefined.doj.accountable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtOrderRepository extends CrudRepository<CourtOrder, Long> {

}
