package com.example.commissionservice.application.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<T, U> {

    private final Function<T, U> fromPojos;
    private final Function<U, T> fromDto;

    public Converter(final Function<T, U> fromPojos, final Function<U, T> fromDto) {
        this.fromPojos = fromPojos;
        this.fromDto = fromDto;
    }

    public final U convertFromPojo(final T pojo) {
        return fromPojos.apply(pojo);
    }

    public final T convertFromDto(final U dto) {
        return fromDto.apply(dto);
    }

    public final List<U> createFromPojos(final Collection<T> pojos) {
        return pojos.stream().map(this::convertFromPojo).collect(Collectors.toList());
    }

    public final List<T> createFromDtos(final Collection<U> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }
}