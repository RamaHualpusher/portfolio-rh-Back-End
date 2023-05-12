package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.PersonHeaderDto;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonHeaderServiceImpl extends BaseServiceImpl<User, Long> {

    private final ModelMapper modelMapper;

    public PersonHeaderServiceImpl(UserRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public PersonHeaderDto convertToDto(User person) {
        return modelMapper.map(person, PersonHeaderDto.class);
    }

    public User convertToEntity(PersonHeaderDto personDto) {
        return modelMapper.map(personDto, User.class);
    }
}
