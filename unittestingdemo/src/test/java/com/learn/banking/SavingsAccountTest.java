package com.learn.banking;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp(){

        account = new SavingsAccount(101, 10000, new Date(), AccountStatus.ACTIVE);
    }

    @AfterEach
    void tearDown(){
        account = null;
    }

    @Test
//    @Order(1)
    void testSuccessfulWithdrawal() throws InsufficientBalanceException {
        boolean actual = account.withdrawAmount(2000);
        assertTrue(actual);
        assertEquals(8000, account.getBalance(), "Balance not deducted as expected");
    }

    @Test
    void testWithdrawalForDormantAccounts() throws InsufficientBalanceException {
        account.setStatus(AccountStatus.DORMANT);
        boolean actual = account.withdrawAmount(1000);
        assertFalse(actual, "Withdrawal should not be allowed from dormant accounts");
    }

    @Test
    void testWithdrawalForAccountsWithInsufficientBalance() throws InsufficientBalanceException {
        assertThrows(InsufficientBalanceException.class, () ->account.withdrawAmount(9600));
    }

    @Test
    void testSuccessfullDeposit(){
        boolean actual = account.depositAmount(1000.5);
        assertTrue(actual);
        assertEquals(11000.5, account.getBalance());
    }

    @Test
//    @Timeout(2)
    void testDepositForClosedAccounts(){
        account.setStatus(AccountStatus.CLOSED);
        boolean actual = account.depositAmount(1000.5);
        assertFalse(actual);
    }

    @Test
    @Disabled
    void testDepositForDORMANTAccounts() throws InterruptedException {
        account.setStatus(AccountStatus.DORMANT);
        boolean actual = account.depositAmount(1000.5);
        assertFalse(actual);
    }

}