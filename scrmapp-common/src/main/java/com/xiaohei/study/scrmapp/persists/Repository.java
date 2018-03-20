package com.xiaohei.study.scrmapp.persists;

public interface Repository<T> {
    int save(T t);

    int update(T t);

    int delete(Long id);

    T findById(Long id);
}
