package brauls.sandbox.springbootsandbox.converter;

import brauls.sandbox.springbootsandbox.dto.UserDto;
import brauls.sandbox.springbootsandbox.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserConverterTest {
    private UserConverter userConverter;
    private User user;
    private UserDto userDto;

    @Before
    public void setUp() {
        this.userConverter = new UserConverter();

        this.userDto = new UserDto(
                1L,
                "test",
                "test@gmail.com"
        );
        this.user = new User();
        this.user.setId(1L);
        this.user.setName("test");
        this.user.setMailAddress("test@gmail.com");
    }

    @Test
    public void convertUser() {
        final var convertedUserDto = this.userConverter.convertUser(this.user);
        assertEquals(this.userDto, convertedUserDto);
    }

    @Test
    public void convertUserDto() {
        final var convertedUser = this.userConverter.convertUser(this.userDto);
        assertEquals(this.user, convertedUser);
    }
}