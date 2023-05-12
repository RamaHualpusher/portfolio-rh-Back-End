package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.UserFullNameDto;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFullNameServiceImpl extends BaseServiceImpl<User, Long> {

    private final ModelMapper modelMapper;

    public UserFullNameServiceImpl(UserRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public UserFullNameDto convertToDto(User user) {
        return modelMapper.map(user, UserFullNameDto.class);
    }

    public User convertToEntity(UserFullNameDto userFullNameDto) {
        return modelMapper.map(userFullNameDto, User.class);
    }
}
