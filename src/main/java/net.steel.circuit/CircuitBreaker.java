package net.steel.circuit;

public class CircuitBreaker {
    public enum CircuitState {
        CLOSED,
        HALF_OPEN,
        OPEN;
    }
}