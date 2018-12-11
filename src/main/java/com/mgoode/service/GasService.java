package com.mgoode.service;

import com.mgoode.repository.GasRepository;
import com.mgoode.model.Gas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by michaelgoode on 18/04/2018.
 */
@Service
public class GasService {

    @Autowired
    GasRepository gasRepository;

    public void save( Gas gas ) {
        gasRepository.save(gas);
    }

    public Page<Gas> findAll( int page, int totalLines ) {
        return gasRepository.findAll( new PageRequest(page,totalLines) );
    }

    public Iterable<Gas> findAll() {
        return gasRepository.findAll();
    }

    public void deleteGas(long id) {
        gasRepository.delete(id);
    }

    public Gas findById( long id ) {
        return gasRepository.findOne(id);
    }

}
