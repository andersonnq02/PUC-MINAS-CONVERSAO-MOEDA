package br.com.currencyconverter.core.exception;

public class CoreException extends RuntimeException {
    public CoreException (String message, Exception e) { super(message, e); }
}
