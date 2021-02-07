package pl.jmatejko.voucherstore.sales.payment;

import pl.jmatejko.payu.exceptions.PayUException;

public class PaymentException extends IllegalStateException {
    public PaymentException(PayUException e) {
        super(e);
    }
}
