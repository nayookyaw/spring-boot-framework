package bisbackend.services.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bisbackend.consts.GlobalConst;
import bisbackend.dao.user.UserDao;
import bisbackend.models.user.User;
import jakarta.persistence.Tuple;

@Service
public class UserService implements UserServiceInterface {
    
    @Autowired
    private UserDao userDao;

    public ResponseEntity<Object> getUser () {
        HashMap<String, Object> resObj = new HashMap<String, Object>();
        Tuple userTuple = userDao.getUser();

        if (userTuple != null) {
            User user = new User();
            user.setId((Long) userTuple.get("id"));
            user.setName((String) userTuple.get("name"));
            user.setUserName((String) userTuple.get("userName"));
            user.setEmail((String) userTuple.get("email"));

            resObj.put("status", GlobalConst.SUCCESS_CODE);
            resObj.put("data", user);
        } else {
            resObj.put("status", GlobalConst.SUCCESS_CODE);
            resObj.put("data", null);
        }
 
        return new ResponseEntity<Object>(resObj, HttpStatus.OK);
    }

    public ResponseEntity<Object> getUserList () {
        HashMap<String, Object> resObj = new HashMap<String, Object>();

        try {
            List<Tuple> userList = userDao.getUserList();
            
            ArrayList<User> userListRes = new ArrayList<User>();
            userList.forEach(row -> {
                User user = new User();
                user.setName((String) row.get("name"));
                user.setUserName((String)row.get("userName"));
                user.setEmail((String) row.get("email"));

                userListRes.add(user);
            });

            resObj.put("status", GlobalConst.SUCCESS_CODE);
            resObj.put("data", userListRes);
        } catch (Exception e) {
            resObj.put("status", GlobalConst.ERROR_CODE);
            resObj.put("data", e.toString()); 
        }

        return new ResponseEntity<Object>(resObj, HttpStatus.OK);     
    }
}
