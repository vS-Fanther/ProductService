package com.task.productservice.domains.user.service;

import com.task.productservice.domains.user.model.dto.AddUserDTO;
import com.task.productservice.domains.user.model.dto.AuthenticateUserDTO;

public interface IUserService {
    void addUser(AddUserDTO addUserDTO);
    String authenticateUser(AuthenticateUserDTO authenticateUserDTO);
}
