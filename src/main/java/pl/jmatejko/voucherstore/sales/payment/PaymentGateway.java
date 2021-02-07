package pl.jmatejko.voucherstore.sales.payment;

import pl.jmatejko.voucherstore.sales.ordering.Reservation;

public interface PaymentGateway {
    PaymentDetails register(Reservation reservation);

    boolean isTrusted(PaymentUpdateStatusRequest paymentUpdateStatusRequest);
}
