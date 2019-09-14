package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LunchOrderTest {
    LunchOrder.Builder builder;

    @BeforeEach
    void setUp() { builder = new LunchOrder.Builder(); }

    @Test
    void givenLunchOrder_whenNullIsPassed_exceptionIsThrown() {
        builder.bread(null)
                .dressing(null)
                .condiments(null)
                .meat(null);

        LunchOrder lunchOrder = builder.build();

        assertEquals(null, lunchOrder.getDressing());
        assertEquals(null, lunchOrder.getBread());
        assertEquals(null, lunchOrder.getCondiments());
        assertEquals(null, lunchOrder.getMeat());
    }

    @Test
    void givenLunchOrder_whenAllTypesOrdered_CorrectOrderIsCorrect() {
        builder
                .bread("Wheat")
                .condiments("Lettuce")
                .dressing("Mayonnaise")
                .meat("Ham");

        LunchOrder lunchOrder = builder.build();

        assertEquals("Wheat", lunchOrder.getBread());
        assertEquals("Lettuce", lunchOrder.getCondiments());
        assertEquals("Mayonnaise", lunchOrder.getDressing());
        assertEquals("Ham", lunchOrder.getMeat());
    }

    @Test
    void givenLunchOrder_whenOnlyCondimentsAndMeatIsOrdered_CorrectOrderIsReturned() {
        builder
                .condiments("Lettuce")
                .meat("Ham");

        LunchOrder lunchOrder = builder.build();

        assertEquals("Lettuce", lunchOrder.getCondiments());
        assertEquals("Ham", lunchOrder.getMeat());
    }
}