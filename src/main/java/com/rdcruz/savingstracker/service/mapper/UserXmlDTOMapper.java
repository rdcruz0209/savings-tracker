package com.rdcruz.savingstracker.service.mapper;

import com.rdcruz.savingstracker.controller.dto.UserXmlDto;
import com.rdcruz.savingstracker.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserXmlDTOMapper implements Function<User, UserXmlDto> {

    public UserXmlDto map(User user){
        return this.apply(user);
    }
    @Override
    public UserXmlDto apply(User user) {
        return UserXmlDto.builder()
                         .userId(user.getUserId())
                         .firstName(user.getFirstName())
                         .lastName(user.getLastName())
                         .userName(user.getUserName())
                         .build();
    }
}
