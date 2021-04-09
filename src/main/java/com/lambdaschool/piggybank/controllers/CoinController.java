package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    //Autowired here -------------------------------------------------------------------------------
    @Autowired
    CoinRepository coinrepo;

    private List<Coin> findCoins(List<Coin> myCoin, CoinTester tester)
    {
        List<Coin> tempList = new ArrayList<>();
        for (Coin c : myCoin) {
            if (tester.test(c)) {
                tempList.add(c);
            }
        }
        return tempList;

    }

    //http://localhost:2019/coins/total
    //Endpoint here (the total) -------------------------------------------------------------------------
    @GetMapping(value = "/total", produces={"application/json"})
    public ResponseEntity<?> getTotalValue()
    {
        List<Coin> myCoin = new ArrayList<>();
        coinrepo.findAll()
                .iterator()
                .forEachRemaining(myCoin::add);
        double coinTotal = 0.0;
        List<String> coinList = new ArrayList<>();
        for (Coin c : myCoin)
        {
            coinTotal = coinTotal + (c.getQuantity() * c.getValue());
            if(c.getQuantity() > 1)
            {
                coinList.add(c.getQuantity() + " " + c.getNameplural() + " \n");
            } else
            {
                coinList.add(c.getQuantity() + " " + c.getName() + "\n");
            }
        }
        //Print out results --------------------------------------------------------------------------
        System.out.println();
        System.out.println("The piggy bank is holding: "+ coinTotal + " coins.");
        return new ResponseEntity<>(coinTotal, HttpStatus.OK);
    }
}








