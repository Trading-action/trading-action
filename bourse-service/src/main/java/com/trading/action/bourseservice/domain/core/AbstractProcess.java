package com.trading.action.bourseservice.domain.core;

public interface AbstractProcess<T extends AbstractProcessInput> {
    Result execute(T abstractProcessInput);
}
