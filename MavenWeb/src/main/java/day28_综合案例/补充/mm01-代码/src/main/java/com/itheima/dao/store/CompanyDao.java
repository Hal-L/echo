package com.itheima.dao.store;

import com.itheima.domain.store.Company;

import java.util.List;

public interface CompanyDao {

    /**
     * TODO 在mybatis核心配置文件中配置驼峰命名和底杠命名的自动转换，以替换到映射配置文件的resultMap
     * @param company
     * @return
     */
    int save(Company company);

    int delete(Company company);

    int update(Company company);

    Company findById(String id);

    List<Company> findAll();

}
