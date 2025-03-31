package com.undefined.doj.accountable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerNoteRepository extends CrudRepository<LawyerNote,Long> {

}
