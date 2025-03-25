package day6;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private String symbol;
    private double price;
    private int volume;
    private LocalDateTime lastTradeTime;

    public Stock(String symbol, double price, int volume, LocalDateTime lastTradeTime) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.lastTradeTime = lastTradeTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public Optional<LocalDateTime> getLastTradeTime() {
        return Optional.ofNullable(lastTradeTime);
    }
}

public class StockMarketAnalyzer {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", 150.5, 10000, LocalDateTime.now().minusHours(5)),
            new Stock("GOOGL", 2800.75, 5000, LocalDateTime.now().minusDays(1)),
            new Stock("MSFT", 299.99, 8000, LocalDateTime.now().minusHours(3)),
            new Stock("TSLA", 720.88, 12000, LocalDateTime.now().minusMinutes(90)),
            new Stock("AMZN", 3400.5, 7000, null) // No last trade record
        );

        // Find the highest-priced stock
        Optional<Stock> highestPricedStock = stocks.stream()
            .max(Comparator.comparing(Stock::getPrice));

        System.out.println("Highest Priced Stock:");
        highestPricedStock.ifPresent(stock ->
            System.out.println(stock.getSymbol() + " - Price: " + stock.getPrice()));

        // Calculate average stock price
        OptionalDouble avgPrice = stocks.stream()
            .mapToDouble(Stock::getPrice)
            .average();

        System.out.println("\nAverage Stock Price:");
        System.out.println(avgPrice.isPresent() ? avgPrice.getAsDouble() : "No stock data available");

        // List stocks traded in the last 24 hours
        LocalDateTime last24Hours = LocalDateTime.now().minusDays(1);
        List<Stock> activeStocks = stocks.stream()
            .filter(s -> s.getLastTradeTime().orElse(LocalDateTime.MIN).isAfter(last24Hours))
            .collect(Collectors.toList());

        System.out.println("\nStocks with trading activity in the last 24 hours:");
        activeStocks.forEach(stock -> System.out.println(stock.getSymbol() + " - Last Trade: " + stock.getLastTradeTime().orElse(null)));
    }
}

