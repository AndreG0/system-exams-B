package com.system.exams.service;

import com.system.exams.entity.User;
import com.system.exams.entity.UserRole;

import java.util.Set;

public interface UserService {

    public User save(User user, Set<UserRole> userRoles) throws Exception;
}
