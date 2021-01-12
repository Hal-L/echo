package com.itheima.user.service.impl;

import com.itheima.user.entity.TbUser;
import com.itheima.user.mapper.TbUserMapper;
import com.itheima.user.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author itheima
 * @since 2020-11-22
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
