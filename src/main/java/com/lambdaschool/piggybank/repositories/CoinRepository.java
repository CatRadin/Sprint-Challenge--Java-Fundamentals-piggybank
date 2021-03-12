package com.lambdaschool.piggybank.repositories;

import com.lambdaschool.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;
//This is the Coin Repository, connecting it up to the rest of the application  -------------------------------------
    public interface CoinRepository extends CrudRepository<Coin, Long>
    {

    }

