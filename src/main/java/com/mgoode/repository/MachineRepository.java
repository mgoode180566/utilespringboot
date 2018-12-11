package com.mgoode.repository;

import com.mgoode.model.Gas;
import com.mgoode.model.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by michaelgoode on 19/04/2018.
 */
@Repository
public interface MachineRepository extends CrudRepository<Machine, Long>{

    Page<Machine> findAll(Pageable page);

    @Query("From Machine where blower='TRUE' and vacuum='FALSE' and cooling=:cooling and minPressure < :minpressure and maxPressure > :maxpressure order by MAX_SPEED")
    public Iterable<Machine> findMachinesByPressureBlowerGas(@Param("cooling") String cooling,
                                                             @Param("minpressure") float minpressure,
                                                             @Param("maxpressure") float maxpressure);

    @Query("From Machine where dry_nat_gas='TRUE' and vacuum='FALSE' and cooling=:cooling and minPressure < :minpressure and maxPressure > :maxpressure order by MAX_SPEED")
    Iterable<Machine> findMachinesByPressureNaturalGas(@Param("cooling") String cooling,
                                                       @Param("minpressure") float minpressure,
                                                       @Param("maxpressure") float maxpressure);

    //@Query("From Machine where other_gas='TRUE' and vacuum='FALSE' and cooling=:cooling and min_pressure > :compressionratio and max_pressure < compressionratio order by MAX_SPEED")

    @Query("From Machine where Cooling = :cooling and other_gas = 'TRUE' and :compressionratio > ((MIN_PRESSURE + 13.92) / 13.92)  and :compressionratio < ((MAX_PRESSURE + 13.92) / 13.92)")
    Iterable<Machine> findMachinesByPressureOtherGas(@Param("cooling") String cooling,
                                                     @Param("compressionratio") double compressionRatio);

    @Query("From Machine where cooling=:cooling")
    Iterable<Machine> findMachinesByCooling(@Param("cooling") String cooling);

}
