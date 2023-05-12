package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SocialDto;
import com.hualpusher.portfolio.entity.Social;
import com.hualpusher.portfolio.repository.SocialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImpl extends BaseServiceImpl<Social, Long> {

    private final ModelMapper modelMapper;

    public SocialServiceImpl(SocialRepository repository) {

        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public SocialDto convertToDto(Social social) {
        return modelMapper.map(social, SocialDto.class);
    }

    public Social convertToEntity(SocialDto socialDto) {
        return modelMapper.map(socialDto, Social.class);
    }
}

