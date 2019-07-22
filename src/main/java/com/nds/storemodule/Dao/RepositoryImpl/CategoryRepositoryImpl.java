package com.nds.storemodule.Dao.RepositoryImpl;

import com.northwind.basemodule.Dao.Repository.CategoryRepository;
import com.northwind.basemodule.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        try {
            List<Category> categoryList = new ArrayList<>();
            categoryList=entityManager.createQuery("select c from Category c",Category.class)
                    .getResultList();
            return categoryList;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Category findById(Integer id) {
        try {
            Category category = entityManager.find(Category.class,id);
            return category;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public int update(Category category) {
        try {
            Category categoryObj = findById(category.getCategoryId());
            categoryObj.setCategoryName(category.getCategoryName());
            categoryObj.setDescription(category.getDescription());
            categoryObj.setPicture(category.getPicture());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int add(Category category) {
        try {
            entityManager.persist(category);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int delete(Integer id) {

        try {
            entityManager.remove(findById(id));
            return 1;
        }catch (NoResultException e){
            return 0;
        }

    }
}
