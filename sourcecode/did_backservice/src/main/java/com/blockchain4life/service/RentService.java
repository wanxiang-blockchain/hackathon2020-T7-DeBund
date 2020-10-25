package com.blockchain4life.service;

import com.blockchain4life.bean.BuildingInfo;
import com.blockchain4life.bean.ContractInfo;
import com.blockchain4life.mock.MockDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.Transaction;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Description:租赁合同签约
 * User: chengran
 * Date: 2020-10-25
 */
@Service
public class RentService {

    @Autowired
    private TransactionService transactionService;

    public BigInteger signRentContract(ContractInfo contractInfo) throws Exception {
        //合同关系入库
        MockDatabase.CONTRACT_TABLE.put(UUID.randomUUID().toString(),contractInfo);
        Transaction transaction = new Transaction();
        transaction.setFrom(contractInfo.getContractPartyA());
        transaction.setTo(contractInfo.getContractPartyB());
        return transactionService.sendTransactionToChain(transaction);
    }
}
