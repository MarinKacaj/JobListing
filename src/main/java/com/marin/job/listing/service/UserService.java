package com.marin.job.listing.service;


import com.marin.job.listing.persistence.model.User;
import com.marin.job.listing.web.dto.UserDto;

public interface UserService {
    User findUserByEmail(String email);

    void createUserAccount(UserDto user);
}
