package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justindodson on 11/3/16.
 */
public class VendingMachineTest {

    private VendingMachine machine;

    public class NotifierStub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }
    @Before
    public void setUp() throws Exception {

        Notifier notifier = new NotifierStub();
        machine = new VendingMachine(notifier, 10, 10,10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    public void vendingWhenStockedReturnsItem() throws Exception {
        machine.addMoney(75);

        Item item = machine.vend("A1");

        assertEquals("Twinkies", item.getName());
    }

    @Test
    public void runningSalesTotalIncrementsAfterAVend() throws Exception {
        machine.addMoney(100);
        machine.vend("A1");

        assertEquals(75, machine.getRunningSalesTotal());

    }
}