package com.blockchain4life.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.Transaction;

import java.math.BigInteger;

/**
 * Description: 门禁
 * User: chengran
 * Date: 2020-10-25
 */
@Service
public class EntraceService {

    @Autowired
    private TransactionService transactionService;

    public BigInteger entranceToBuilding(String personDidCode, String  entraceDidCode) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTo(entraceDidCode);
        transaction.setFrom(personDidCode);
        return transactionService.sendTransactionToChain(transaction);
    }
}
