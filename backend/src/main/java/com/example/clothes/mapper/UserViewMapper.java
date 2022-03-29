package com.example.clothes.mapper;

import com.example.clothes.dto.UserView;
import com.example.clothes.security.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserViewMapper {
    UserViewMapper INSTANCE = Mappers.getMapper(UserViewMapper.class);
    UserView UsertoUserView(User user);

    List<UserView> toUserView(List<User> users);



}