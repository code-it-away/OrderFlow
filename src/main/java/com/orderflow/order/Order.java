package com.orderflow.order;

import java.util.Objects;
import java.util.UUID;

/** A minimal immutable order model focused on lifecycle transitions. */
public final class Order {
    private final UUID id;
    private final OrderStatus status;

    private Order(UUID id, OrderStatus status) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.status = Objects.requireNonNull(status, "status must not be null");
    }

    public static Order create() {
        return new Order(UUID.randomUUID(), OrderStatus.CREATED);
    }

    public UUID id() {
        return id;
    }

    public OrderStatus status() {
        return status;
    }

    /** Returns the next order state, preserving the order's identity. */
    public Order transitionTo(OrderStatus nextStatus) {
        Objects.requireNonNull(nextStatus, "nextStatus must not be null");

        if (!status.canTransitionTo(nextStatus)) {
            throw new InvalidOrderTransitionException(status, nextStatus);
        }

        return new Order(id, nextStatus);
    }
}
