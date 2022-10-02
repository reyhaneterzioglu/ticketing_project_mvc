package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding // we no longer need this, spring does the binding automatically
public class UserDtoConverter implements Converter<String, UserDTO> {
    UserService userService;

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
