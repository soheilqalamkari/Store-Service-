package com.nds.storemodule.Dao.Repository;

import com.nds.storemodule.Model.Guarantee;

import java.util.List;

public interface GuaranteeRepository {

    List<Guarantee> findAll();

    Guarantee findById(Integer id);

    int update(Guarantee guarantee);

    int add(Guarantee guarantee);

    int delete(Integer id);
}
