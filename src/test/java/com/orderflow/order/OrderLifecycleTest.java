package com.orderflow.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class OrderLifecycleTest {

    @Test
    void newOrderStartsCreated() {
        Order order = Order.create();

        assertEquals(OrderStatus.CREATED, order.status());
    }

    @ParameterizedTest
    @MethodSource("allowedTransitions")
    void appliesEveryDefinedTransition(OrderStatus currentStatus, OrderStatus nextStatus) {
        Order currentOrder = orderWithStatus(currentStatus);
        Order nextOrder = currentOrder.transitionTo(nextStatus);

        assertEquals(nextStatus, nextOrder.status());
        assertEquals(currentStatus, currentOrder.status());
        assertEquals(currentOrder.id(), nextOrder.id());
    }

    static Stream<Arguments> allowedTransitions() {
        return Stream.of(
                Arguments.of(OrderStatus.CREATED, OrderStatus.CONFIRMED),
                Arguments.of(OrderStatus.CREATED, OrderStatus.CANCELLED),
                Arguments.of(OrderStatus.CONFIRMED, OrderStatus.SHIPPED),
                Arguments.of(OrderStatus.CONFIRMED, OrderStatus.CANCELLED),
                Arguments.of(OrderStatus.SHIPPED, OrderStatus.DELIVERED));
    }

    @ParameterizedTest
    @CsvSource({
        "CREATED, CREATED",
        "CREATED, SHIPPED",
        "CONFIRMED, DELIVERED",
        "SHIPPED, CANCELLED",
        "DELIVERED, CANCELLED",
        "CANCELLED, CREATED"
    })
    void rejectsUndefinedTransitions(OrderStatus currentStatus, OrderStatus nextStatus) {
        assertThrows(
                InvalidOrderTransitionException.class,
                () -> orderWithStatus(currentStatus).transitionTo(nextStatus));
    }

    @Test
    void validTransitionPreservesIdentityAndLeavesOriginalUnchanged() {
        Order created = Order.create();
        UUID id = created.id();

        Order confirmed = created.transitionTo(OrderStatus.CONFIRMED);

        assertNotSame(created, confirmed);
        assertEquals(id, confirmed.id());
        assertEquals(OrderStatus.CREATED, created.status());
        assertEquals(OrderStatus.CONFIRMED, confirmed.status());
    }

    @Test
    void invalidTransitionLeavesOriginalUnchanged() {
        Order created = Order.create();

        assertThrows(
                InvalidOrderTransitionException.class,
                () -> created.transitionTo(OrderStatus.SHIPPED));

        assertEquals(OrderStatus.CREATED, created.status());
    }

    private static Order orderWithStatus(OrderStatus status) {
        Order order = Order.create();
        return switch (status) {
            case CREATED -> order;
            case CONFIRMED -> order.transitionTo(OrderStatus.CONFIRMED);
            case SHIPPED -> order.transitionTo(OrderStatus.CONFIRMED).transitionTo(OrderStatus.SHIPPED);
            case DELIVERED -> order.transitionTo(OrderStatus.CONFIRMED)
                    .transitionTo(OrderStatus.SHIPPED)
                    .transitionTo(OrderStatus.DELIVERED);
            case CANCELLED -> order.transitionTo(OrderStatus.CANCELLED);
        };
    }
}
