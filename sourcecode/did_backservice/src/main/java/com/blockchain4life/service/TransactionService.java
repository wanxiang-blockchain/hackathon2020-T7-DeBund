package com.blockchain4life.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

/**
 * Description:与链交易
 * User: chengran
 * Date: 2020-10-24
 */
@Service
@Slf4j
public class TransactionService {

    public BigInteger sendTransactionToChain(Transaction transaction) throws Exception {
        BigInteger blockNumber = null;
        try {
            EthBlockNumber ethBlockNumber = Web3j.build(new HttpService("http://127.0.0.1:8044")).ethBlockNumber().send();
            blockNumber = ethBlockNumber.getBlockNumber();
        } catch (Exception e) {
            log.error("=============send transaction to chain failed===============\n {}",e);
            throw new Exception("send transaction to chain failed");
        }
        return blockNumber;
    }

    public String getTransactionFromChain(String transactionHash) throws Exception {
        String result = null;
        try {
            Request<?, EthTransaction> ethTransactionRequest = Web3j.build(new HttpService("http://127.0.0.1:8044")).ethGetTransactionByHash(transactionHash);
            result = ethTransactionRequest.getJsonrpc();
        } catch (Exception e) {
            log.error("=============send transaction to chain failed===============\n {}",e);
            throw new Exception("send transaction to chain failed");
        }
        return result;
    }

}
