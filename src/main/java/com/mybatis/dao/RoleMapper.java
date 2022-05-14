package com.mybatis.dao;

import com.mybatis.bean.Role;
import com.mybatis.bean.RoleQueryVo;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据多个id查询角色列表
     * @param ids
     * @return
     */
    List<Role> queryRolesByIds(RoleQueryVo vo);

}
