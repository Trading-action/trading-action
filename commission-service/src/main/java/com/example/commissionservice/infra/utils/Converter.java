package com.example.commissionservice.infra.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<T, U> {

    private final Function<T, U> fromPojos;
    private final Function<U, T> fromEntity;

    public Converter(final Function<T, U> fromPojo, final Function<U, T> fromEntity) {
        this.fromPojos = fromPojo;
        this.fromEntity = fromEntity;
    }

    public final U convertFromPojos(final T pojo) {
        return fromPojos.apply(pojo);
    }

    public final T convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    public final List<U> createFromPojos(final Collection<T> pojos) {
        return pojos.stream().map(this::convertFromPojos).collect(Collectors.toList());
    }

    public final List<T> createFromEntities(final Collection<U> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}