package com.trading.action.bourse.domain.core;

public abstract class AbstractProcessImpl<T extends AbstractProcessInput> {


    public Result execute(T abstractProcessInput) {
        Result result = new Result();
        if (validateProcess(abstractProcessInput, result)) {
            run(abstractProcessInput, result);
        }
        return result;
    }

    public boolean validateProcess(T abstractProcessInput, Result result) {
        validate(abstractProcessInput, result);
        return result.hasError();
    }


    public abstract void validate(T abstractProcessInput, Result result);

    public abstract void run(T abstractProcessInput, Result result);

}
