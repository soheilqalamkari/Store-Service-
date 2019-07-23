package com.nds.storemodule.Service.RepositoryServiceImpl;

import com.nds.storemodule.Dao.Repository.CategoryRepository;
import com.nds.storemodule.Model.Category;
import com.nds.storemodule.Service.RepositoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return findById(id);
    }

    @Override
    public int update(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public int add(Category category) {
        return categoryRepository.add(category);
    }

    @Override
    public int delete(Integer id) {
        return categoryRepository.delete(id);
    }
}
