package brauls.sandbox.springbootsandbox.controller;

import brauls.sandbox.springbootsandbox.dto.UserDto;
import brauls.sandbox.springbootsandbox.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
    List<UserDto> getUsers(
            @ApiParam(name = "sort", value = "the sorting attribute") @RequestParam("sort") String sortAttr
    ) {
        switch (sortAttr) {
            case "name": return this.userService.getUsersSortedByName();
            case "mail": return this.userService.getUsersSortedByMailAddress();
            default: return this.userService.getUsers();
        }
    }

}
