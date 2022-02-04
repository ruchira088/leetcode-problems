package com.ruchij;

import java.util.*;

public class StockPrice {
    record Stock(int timestamp, int price) {
    }

    private final PriorityQueue<Stock> min =
            new PriorityQueue<Stock>(Comparator.comparingInt(Stock::price));

    private final PriorityQueue<Stock> max =
            new PriorityQueue<Stock>(Comparator.comparingInt(Stock::price).reversed());

    private final Set<Integer> timestamps = new HashSet<>();
    private final Map<Integer, Integer> corrections = new HashMap<>();

    private Stock current = null;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        Stock stock = new Stock(timestamp, price);
        min.add(stock);
        max.add(stock);

        if (current == null || current.timestamp <= timestamp) {
            current = new Stock(timestamp, price);
        }

        if (timestamps.contains(timestamp)) {
            corrections.put(timestamp, price);
        }

        timestamps.add(timestamp);
    }

    public int current() {
        return current.price;
    }

    public int maximum() {
        Stock peek = max.peek();
        Integer correction = corrections.get(peek.timestamp);

        if (correction == null || correction == peek.price) {
            return peek.price;
        } else {
            max.remove();
            return maximum();
        }
    }

    public int minimum() {
        Stock peek = min.peek();
        Integer correction = corrections.get(peek.timestamp);

        if (correction == null || correction == peek.price) {
            return peek.price;
        } else {
            min.remove();
            return minimum();
        }
    }
}
