package user.info.user;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Jedis jedis;

    @Autowired
    Gson gson;



    public List<MyUser> getAllUser(){
        List<MyUser> users = new ArrayList<MyUser>();
        userRepository.findAll().forEach(users::add);
        return users;

    }


    public MyUser saveUser(MyUser user) {
        String local = user.getId().toString();
        String json = gson.toJson(user);
        jedis.set(local,json);
        return userRepository.save(user);
    }

    public MyUser userid(Integer userid){
        String value = jedis.get("userid");
        if(value==null)
        {
            throw new UserNotFoundException("Request User Does Not Exist");
         //   return userRepository.findById(userid).get();
        }
        else
        {
            MyUser val = gson.fromJson(value,MyUser.class);
            return val;
        }

     }



}
