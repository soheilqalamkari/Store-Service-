package com.nds.storemodule.Dao.Repository;

import com.northwind.basemodule.Model.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll();

    Category findById(Integer id);

    int update(Category category);

    int add(Category category);

    int delete(Integer id);
}
