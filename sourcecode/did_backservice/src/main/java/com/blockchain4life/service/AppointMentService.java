package com.blockchain4life.service;

import com.blockchain4life.bean.AppointmentRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.Transaction;

import java.math.BigInteger;

/**
 * Description:
 * User: chengran
 * Date: 2020-10-25
 */
@Service
public class AppointMentService {

    @Autowired
    private TransactionService transactionService;
    /**
     * 发起预约
     * @return
     */
    public BigInteger createAppointment(AppointmentRequestInfo requestInfo) throws Exception {
        Transaction transaction = new Transaction();
        return transactionService.sendTransactionToChain(transaction);
    }

    /**
     * 审核预约信息
     * @return
     */
    public BigInteger acceptAppointment(AppointmentRequestInfo personDidCode) throws Exception {
        Transaction transaction = new Transaction();
        return transactionService.sendTransactionToChain(transaction);
    }
}
