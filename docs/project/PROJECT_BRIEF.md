# Project brief

## Purpose

OrderFlow is the user's primary integrated learning project: a realistic order tracking system built incrementally to practise production-grade backend engineering. It complements, rather than replaces, standalone learning and interview practice.

The application is the place to learn concepts that benefit from realistic context. DSA remains a separate recurring practice track. Java concurrency concepts may use isolated experiments when that teaches them better than adding artificial concurrency to the application.

## Initial scope

The eventual system covers catalogue and inventory, orders and status history, cancellation, authentication and authorisation, idempotency, reliable event processing, shipment tracking, notifications, operational visibility, testing, and deployment.

## Domain terms

- **Order**: a customer's request to purchase one or more products.
- **Order status**: the current lifecycle state of an order; transitions must be valid and auditable.
- **Inventory**: sellable quantity reserved or released as an order changes state.

## Non-goals for the foundation

No persistence, public business endpoint, authentication, messaging, or container deployment is implemented yet.
