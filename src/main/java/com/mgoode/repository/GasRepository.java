package com.mgoode.repository;

import com.mgoode.model.Gas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michaelgoode on 18/04/2018.
 */
@Repository
public interface GasRepository extends CrudRepository<Gas, Long> {
    Page<Gas> findAll(Pageable page);
}
