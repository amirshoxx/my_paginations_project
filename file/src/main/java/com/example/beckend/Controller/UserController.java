

package com.example.beckend.Controller;

import com.example.beckend.Db;
import com.example.beckend.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ArrayList<User> getUser() {
        return Db.users;
    }

    @PostMapping
    public ArrayList<User> saveUser(@RequestBody User user) {
        User.lastId++;

        user.setId(User.lastId);

        Db.users.add(user);

        return Db.users;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        Iterator<User> iterator = Db.users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
    @PutMapping(path = "/{id}")
    public User editStudent(@PathVariable Integer id, @RequestBody User user) {
        for (User user1 : Db.users) {
            if (user1.getId().equals(id)) {
                user1.setLast(user.getLast());
                user1.setFirst(user.getFirst());
                user1.setAge(user.getAge());
                user1.setImg(user.getImg());
            }
        }

        return null;
    }

}
