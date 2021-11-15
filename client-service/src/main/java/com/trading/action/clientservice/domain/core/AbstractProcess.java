package com.trading.action.clientservice.domain.core;

public interface AbstractProcess<T extends AbstractProcessInput> {
    Result execute(T abstractProcessInput);
}
