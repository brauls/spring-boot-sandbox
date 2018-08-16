package brauls.sandbox.springbootsandbox.controller;

import brauls.sandbox.springbootsandbox.dto.UserDto;
import brauls.sandbox.springbootsandbox.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(
            UserService userService
    ) {
        Assert.notNull(userService, "UserService must not be null");
        this.userService = userService;
    }

    @ApiOperation("Gets the list of available users")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    List<UserDto> getUsers() {
        return this.userService.getUsers();
    }

}
