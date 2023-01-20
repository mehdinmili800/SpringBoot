package com.ecommerce.library.service.Impl;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.repository.CategoryRepository;
import com.ecommerce.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> finAll() {
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
            Category categorySave = new Category(category.getName());
            return repository.save(categorySave);


    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = null;
        try{
            categoryUpdate = repository.findById(category.getId()).get();
            categoryUpdate.setName(category.getName());
            categoryUpdate.set_activated(category.is_activated());
            categoryUpdate.set_deleted(category.is_deleted());
        }catch (Exception e){
            e.printStackTrace();
        }


        return repository.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Category category = repository.getById(id);
        category.set_deleted(true);
        category.set_activated(false);
        repository.save(category);


    }

    @Override
    public void enabledById(Long id) {
        Category category = repository.getById(id);
        category.set_activated(true);
        category.set_deleted(false);
        repository.save(category);

    }

    @Override
    public List<Category> findAllByActivated() {
        return repository.findAllByActivated();
    }




    /*Customer*/

    @Override
    public List<CategoryDto> getCategoryAndProduct() {
        return repository.getCategoryAndProduct();
    }
}
