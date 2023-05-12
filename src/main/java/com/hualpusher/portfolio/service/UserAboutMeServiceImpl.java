package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.UserAboutMeDto;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAboutMeServiceImpl extends BaseServiceImpl<User, Long> {

    private final ModelMapper modelMapper;

    public UserAboutMeServiceImpl(UserRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public UserAboutMeDto convertToDto(User user) {
        return modelMapper.map(user, UserAboutMeDto.class);
    }

    public User convertToEntity(UserAboutMeDto userAboutMeDto) {
        return modelMapper.map(userAboutMeDto, User.class);
    }
}
