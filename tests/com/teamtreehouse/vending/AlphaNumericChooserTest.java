package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by justindodson on 10/26/16.
 */
public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {

        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");

        assertEquals("proper row", 1, loc.getRow());
        assertEquals("proper column", 3, loc.getColumn());

    }

    //How to write a test to check an exception
    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        chooser.locationFromInput("Wrong"); // Invalid input string to promote an exception to be thrown.

    }

    @Test(expected = InvalidLocationException.class)
    public void locationRowsAndColumsMustBeWithinTheLimits() throws Exception {
        chooser.locationFromInput("B12");


    }

}