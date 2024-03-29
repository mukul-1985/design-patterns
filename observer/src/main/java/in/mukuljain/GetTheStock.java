package in.mukuljain;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {
    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice) {
        this.stockGrabber = stockGrabber;
        this.startTime = newStartTime;
        this.stock = newStock;
        this.price = newPrice;
    }
    @Override
    public void run() {
        for(int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}

            double randum = (Math.random() * (0.06)) - 0.03;

            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format((price + randum)));

            if (stock == "IBM") ((StockGrabber)stockGrabber).setIbmPrice(price);
            if (stock == "AAPL") ((StockGrabber)stockGrabber).setAaplPrice(price);
            if (stock == "GOOG") ((StockGrabber)stockGrabber).setGoogPrice(price);

            System.out.println(stock + ": " + df.format(price + randum) +
                    " " + df.format(randum));
            System.out.println();
        }
    }
}
