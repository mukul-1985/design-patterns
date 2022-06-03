package in.mukuljain;

public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197.00);
        stockGrabber.setAaplPrice(766.00);
        stockGrabber.setGoogPrice(897.00);

        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(192.00);
        stockGrabber.setAaplPrice(996.00);
        stockGrabber.setGoogPrice(444.00);

        stockGrabber.unregister(observer1);
        stockGrabber.setIbmPrice(1923.00);
        stockGrabber.setAaplPrice(9962.00);
        stockGrabber.setGoogPrice(4441.00);

        Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
        Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.00);

        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();
    }
}
