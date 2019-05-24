package com.todo.app.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    List<String> load();
    void save(List<String> list);
    void changeStatus(int index);
    void delete(int index);
}
