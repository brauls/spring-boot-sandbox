package brauls.sandbox.springbootsandbox.service;

import brauls.sandbox.springbootsandbox.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
