package com.example.clothes.mapper;

import com.example.clothes.models.SignupRequest;
import com.example.clothes.security.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface SignupRequestToUserMapper {
    SignupRequestToUserMapper INSTANCE = Mappers.getMapper(SignupRequestToUserMapper.class);
    User toUser(SignupRequest request);

    List<User> toUser(List<SignupRequest> requests);
}
