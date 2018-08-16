package brauls.sandbox.springbootsandbox.converter;

import brauls.sandbox.springbootsandbox.dto.UserDto;
import brauls.sandbox.springbootsandbox.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto convertUser(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getMailAddress()
        );
    }

    public User convertUser(UserDto userDto) {
        final var user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setMailAddress(userDto.getMailAddress());
        return user;
    }
}
