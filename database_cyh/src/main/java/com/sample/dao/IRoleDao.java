package com.sample.dao;

import com.sample.domain.Role;

import java.util.List;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public interface IRoleDao {
    List<Role> findAll();
}
