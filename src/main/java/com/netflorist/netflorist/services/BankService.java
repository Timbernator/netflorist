/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.services;

import com.netflorist.netflorist.entity.Bank;
import com.netflorist.netflorist.repository.BankRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reverside
 */
@Service
public class BankService {
     @Autowired
    private BankRepository bankRepository;
    //private Bank Bank;
    private static List<Bank> banks;
    


    public List<Bank> findAllBanks()
    {

 
        banks = new ArrayList<>();
        
        bankRepository.findAll().forEach(banks::add);
        
       
        return banks; 
    }
    public Bank findBankBy(Long id)
    {

        return bankRepository.findOne(id);
    }

    public void saveBank(Bank  bank) {

       bankRepository.save(bank);
    }
    public void updateBank(Long id, Bank bank)
    {

        bankRepository.save(bank);
    }

    public void deleteBank(Long id) {

        bankRepository.delete(id);
        
    }
    
    public Bank payment(String accountNo, String pin)
    {
        Bank bank = null;
       
        List<Bank> banks = findAllBanks();
        
        for(int x = 0 ; x < banks.size() ; x++)
        {
            if (banks.get(x).getAccountNo().equalsIgnoreCase(accountNo) &&banks.get(x).getPin().equalsIgnoreCase(pin) )
            {
                bank=banks.get(x);
                break;
            }
            
        }
       
        return bank;
    }
}
