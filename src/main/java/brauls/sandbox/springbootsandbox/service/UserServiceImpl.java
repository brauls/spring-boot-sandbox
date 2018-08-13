package brauls.sandbox.springbootsandbox.service;

import brauls.sandbox.springbootsandbox.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDto> getUsers() {
        var users = new ArrayList<UserDto>();
        users.add(new UserDto(
                "1",
                "Benedikt",
                "brauls101@gmail.com"
        ));
        return users;
    }
}
