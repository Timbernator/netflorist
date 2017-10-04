/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.web;

import com.netflorist.netflorist.entity.Bank;
import com.netflorist.netflorist.services.BankService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Reverside
 */
@RestController
public class BankControl {
    @Autowired
    private BankService bankService;
    private List<Bank> banks;

    @RequestMapping(method = RequestMethod.GET, value = "/banks")
    public List<Bank> getAll()
    {
        banks = new ArrayList<>();
        bankService.findAllBanks().forEach(banks::add);
        return banks;
    }
 
    @RequestMapping("/banks/{id}")
    public Bank getBankbyId(@PathVariable Long id) {
        
        return bankService.findBankBy(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/banks")
    public void addBank(@RequestBody Bank bank)
    {
        bankService.saveBank(bank);
    }
    
    @RequestMapping(method = RequestMethod.PUT,value = "/banks/{id}")
    public void updateBank(@RequestBody Bank bank,@PathVariable Long id)
    {
        bankService.updateBank(id, bank);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/banks/{id}")
    public void deleteBank(@PathVariable Long id)
    {
        bankService.deleteBank(id);
    }
    

    @RequestMapping(method = RequestMethod.GET, value = "/payment",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Bank login(@RequestParam String accountNo, String pin) {
        
        return bankService.payment(accountNo, pin);
    }
}
