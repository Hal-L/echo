package com.itheima.service.store.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.store.CompanyDao;
import com.itheima.domain.store.Company;
import com.itheima.service.store.CompanyService;
import com.itheima.utils.MybatisUtil;

import java.util.List;
import java.util.UUID;


public class CompanyServiceImpl implements CompanyService {
    @Override
    public void save(Company company) {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);
        //id使用UUID的生成策略来获取
        String id = UUID.randomUUID().toString();
        company.setId(id);
        //3.调用Dao层操作
        companyDao.save(company);

    }

    @Override
    public void delete(Company company) {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);

        //3.调用Dao层操作
        companyDao.delete(company);
        //4.提交事务
    }

    @Override
    public void update(Company company) {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);

        //3.调用Dao层操作
        companyDao.update(company);
        //4.提交事务

    }

    @Override
    public Company findById(String id) {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);

        //3.调用Dao层操作
        return companyDao.findById(id);
    }

    @Override
    public List<Company> findAll() {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);

        //3.调用Dao层操作
        return companyDao.findAll();
    }

    @Override
    public PageInfo findAll(int page, int size) {
        CompanyDao companyDao = MybatisUtil.getMapper(CompanyDao.class);


        //3.调用Dao层操作
        PageHelper.startPage(page, size);
        List<Company> all = companyDao.findAll();
        PageInfo pageInfo = new PageInfo(all);
        return pageInfo;

    }
}
