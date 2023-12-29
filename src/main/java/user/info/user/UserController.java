package user.info.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("/getUser/{userid}")
    public MyUser getUser(@PathVariable Integer userid){
        return userService.userid(userid);
    }

    @PostMapping("/saveUser")
    public MyUser saveUser(@RequestBody MyUser user){
        return userService.saveUser(user);
    }


    @GetMapping("/getAllUser")
    public List<MyUser> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getAllUserDev1")
    public List<MyUser> getAllUserDev1() {
        return userService.getAllUser();
    }

    @GetMapping("/getAllUserProd1")
    public List<MyUser> getAllUserDev3() {
        return userService.getAllUser();
    }
}


