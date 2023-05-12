package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.UserContactDto;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserContactServiceImpl extends BaseServiceImpl<User, Long> {

    private final ModelMapper modelMapper;

    public UserContactServiceImpl(UserRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public UserContactDto convertToDto(User user) {
        return modelMapper.map(user, UserContactDto.class);
    }

    public User convertToEntity(UserContactDto userContactDto) {
        return modelMapper.map(userContactDto, User.class);
    }
}

