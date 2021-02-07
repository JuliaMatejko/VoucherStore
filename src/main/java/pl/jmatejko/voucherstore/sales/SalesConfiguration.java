package pl.jmatejko.voucherstore.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jmatejko.payu.http.JavaHttpPayUApiClient;
import pl.jmatejko.payu.PayU;
import pl.jmatejko.payu.PayUCredentials;
import pl.jmatejko.voucherstore.productcatalog.ProductCatalogFacade;
import pl.jmatejko.voucherstore.sales.basket.InMemoryBasketStorage;
import pl.jmatejko.voucherstore.sales.offer.OfferMaker;
import pl.jmatejko.voucherstore.sales.ordering.ReservationRepository;
import pl.jmatejko.voucherstore.sales.payment.PayUPaymentGateway;
import pl.jmatejko.voucherstore.sales.payment.PaymentGateway;
import pl.jmatejko.voucherstore.sales.product.ProductCatalogProductDetailsProvider;
import pl.jmatejko.voucherstore.sales.product.ProductDetailsProvider;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(ProductCatalogFacade productCatalogFacade, OfferMaker offerMaker, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        return new SalesFacade(
                productCatalogFacade,
                new InMemoryBasketStorage(),
                () -> "customer_1",
                (productId) -> true,
                offerMaker,
                paymentGateway,
                reservationRepository);
    }

    @Bean
    PaymentGateway payUPaymentGateway() {
        return new PayUPaymentGateway(new PayU(
                PayUCredentials.productionOfEnv(),
                new JavaHttpPayUApiClient()
        ));
    }

    @Bean
    OfferMaker offerMaker(ProductDetailsProvider productDetailsProvider) {
        return new OfferMaker(productDetailsProvider);
    }

    @Bean
    ProductDetailsProvider productDetailsProvider(ProductCatalogFacade productCatalogFacade) {
        return new ProductCatalogProductDetailsProvider(productCatalogFacade);
    }
}
