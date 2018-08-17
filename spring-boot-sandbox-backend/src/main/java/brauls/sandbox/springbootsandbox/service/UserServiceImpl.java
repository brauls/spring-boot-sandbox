package brauls.sandbox.springbootsandbox.service;

import brauls.sandbox.springbootsandbox.converter.UserConverter;
import brauls.sandbox.springbootsandbox.dto.UserDto;
import brauls.sandbox.springbootsandbox.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(
            UserRepository userRepository,
            UserConverter userConverter
    ) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDto> getUsers() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .map(this.userConverter::convertUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersSortedByName() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .map(this.userConverter::convertUser)
                .sorted(Comparator.comparing(UserDto::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersSortedByMailAddress() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .map(this.userConverter::convertUser)
                .sorted(Comparator.comparing(UserDto::getMailAddress))
                .collect(Collectors.toList());
    }
}
