package com.viaro.test.viaro.service;

import java.util.List;

public interface CrudService <I, C> {
    C findById(I id);
    List<C> list();
    void save(C dto);
    void delete (I id);
}
