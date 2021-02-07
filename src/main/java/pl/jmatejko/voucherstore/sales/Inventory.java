package pl.jmatejko.voucherstore.sales;

public interface Inventory {
    boolean isAvailable(String productId);
}
