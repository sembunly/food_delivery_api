package com.bunli.service;

import com.bunli.dto.MenuItemRequest;
import com.bunli.dto.MenuItemResponse;

import java.util.List;

public interface MenuItemService {

    MenuItemResponse create(MenuItemRequest menuItemRequest);

    MenuItemResponse update(Long id, MenuItemRequest menuItemRequest);

    void delete(Long id);

    MenuItemResponse getById(Long id);

    List<MenuItemResponse> getAll();
}
