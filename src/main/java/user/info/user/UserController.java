package user.info.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<MyUser> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getUser/{userid}")
    public MyUser getUser(@PathVariable Integer userid){
        return userService.userid(userid);
    }

    @PostMapping("/saveUser")
    public MyUser saveUser(@RequestBody MyUser user){
        return userService.saveUser(user);
    }


}

