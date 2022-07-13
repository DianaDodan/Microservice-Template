package com.stockmanagement.app.domain;

import java.util.Objects;
import java.util.UUID;

public class StockItem {
    private final UUID id;
    private final String name;
    private final int quantity;

    public StockItem(UUID id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return quantity == stockItem.quantity && Objects.equals(id, stockItem.id) && Objects.equals(name, stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity);
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
