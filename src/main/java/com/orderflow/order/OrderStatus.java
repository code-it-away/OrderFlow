package com.orderflow.order;

import java.util.Objects;

/** Lifecycle states for an order. Allowed forward transitions are defined here. */
public enum OrderStatus {
    CREATED,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED;

    public boolean canTransitionTo(OrderStatus nextStatus) {
        Objects.requireNonNull(nextStatus, "nextStatus must not be null");

        return switch (this){
            case CREATED -> nextStatus == CONFIRMED || nextStatus == CANCELLED;
            case CONFIRMED -> nextStatus == SHIPPED || nextStatus == CANCELLED;
            case SHIPPED -> nextStatus == DELIVERED;
            case DELIVERED, CANCELLED -> false;
        };
    }
}
