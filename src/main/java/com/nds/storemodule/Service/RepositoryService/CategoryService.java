package com.nds.storemodule.Service.RepositoryService;

import com.nds.storemodule.Model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    int update(Category category);

    int add(Category category);

    int delete(Integer id);
}
