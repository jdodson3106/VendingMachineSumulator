package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justindodson on 10/25/16.
 */
public class CreditorTest {

    private Creditor creditor;
    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();

    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {

        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {

        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {

        creditor.addFunds(100);

        int refund = creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());

    }

    @Test(expected = NotEnoughFundsException.class)
    public void cannotShopWithoutEnoughFunds() throws Exception {

        creditor.deduct(creditor.getAvailableFunds() + 10);
    }
}