package com.example.clevertec_test_task.mapper;

import com.example.clevertec_test_task.dto.AbstractDto;
import com.example.clevertec_test_task.entity.AbstractEntity;

import java.util.Collection;
import java.util.List;

public interface Mapper <E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(Collection<D> dtos);

    List<D> toDto(Collection<E> entities);
}
