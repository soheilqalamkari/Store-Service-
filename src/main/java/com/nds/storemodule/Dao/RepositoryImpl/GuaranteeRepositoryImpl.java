package com.nds.storemodule.Dao.RepositoryImpl;

import com.nds.storemodule.Dao.Repository.GuaranteeRepository;
import com.nds.storemodule.Model.Guarantee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GuaranteeRepositoryImpl implements GuaranteeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Guarantee> findAll() {
        try {
            List<Guarantee> guarantees = new ArrayList<>();
            guarantees=entityManager.createQuery("select g from Guarantee g",Guarantee.class)
                    .getResultList();
            return guarantees;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Guarantee findById(Integer id) {
        try {
            Guarantee guarantee = entityManager.find(Guarantee.class,id);
            return guarantee;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public int update(Guarantee guarantee) {
        try {
            Guarantee guaranteeObj = findById(guarantee.getGuaranteeId());
            guaranteeObj.setDescription(guarantee.getDescription());
            guaranteeObj.setGuaranteeName(guarantee.getGuaranteeName());
            entityManager.merge(guaranteeObj);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int add(Guarantee guarantee) {
        try {
            entityManager.persist(guarantee);
            return 1;
        }catch (Exception e)
            return 0;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            entityManager.remove(findById(id));
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
