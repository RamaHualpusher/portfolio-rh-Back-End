package com.hualpusher.portfolio.service;

import com.hualpusher.portfolio.dto.SocialDto;
import com.hualpusher.portfolio.entity.Social;
import com.hualpusher.portfolio.entity.User;
import com.hualpusher.portfolio.repository.SocialRepository;
import com.hualpusher.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImpl extends BaseServiceImpl<Social, Long> {
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public SocialServiceImpl(SocialRepository repository) {
        super(repository);
        this.modelMapper = new ModelMapper();
    }

    public SocialDto convertToDto(Social social) {
        SocialDto socialDto = modelMapper.map(social, SocialDto.class);
        socialDto.setUserId(social.getUser().getId()); // Asignar userId de Social a SocialDto
        return socialDto;
    }

    public Social convertToEntity(SocialDto socialDto) {
        Social social = modelMapper.map(socialDto, Social.class);
        if (socialDto.getUserId() != null) {
            User user = userRepository.findById(socialDto.getUserId()) // Buscar el usuario por userId
                    .orElseThrow(() -> new RuntimeException("User not found with id " + socialDto.getUserId())); // Lanzar excepción si el usuario no se encuentra
            social.setUser(user); // Asignar el usuario a la entidad social
        }
        return social;
    }
}


