package pl.jmatejko.payu.exceptions;

public class PayUException extends Exception {
    public PayUException(Exception e) {
        super(e);
    }
}
