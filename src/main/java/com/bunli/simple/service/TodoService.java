package com.bunli.simple.service;

import com.bunli.simple.dto.TodoRequest;
import com.bunli.simple.dto.TodoResponse;

import java.util.List;

public interface TodoService {

    void create(TodoRequest todoRequest);

    void update(Long id, TodoRequest todoRequest);

    void delete(Long id);

    TodoResponse getById(Long id);

    List<TodoResponse> getAll();
}
