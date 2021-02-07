package pl.jmatejko.voucherstore.sales.product;

public interface ProductDetailsProvider {
    ProductDetails getByProductId(String productId);
}
