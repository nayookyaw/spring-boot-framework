package bisbackend.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bisbackend.consts.GlobalConst;
import bisbackend.services.user.UserService;

@RestController
@RequestMapping("/user/")
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public ResponseEntity<Object> greeting () {
        try {
            return userService.getUser();
        } catch (Exception e) {
            HashMap<String, Object> resObj = new HashMap<String, Object>();
            resObj.put("status", GlobalConst.ERROR_CODE);
            resObj.put("message", e.getLocalizedMessage());
            return new ResponseEntity<Object>(resObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<Object> getUserList() {
        try {
            return userService.getUserList();
        } catch (Exception e) {
            HashMap<String, Object> resObj = new HashMap<String, Object>();
            resObj.put("status", GlobalConst.ERROR_CODE);
            resObj.put("message", e.getLocalizedMessage());
            return new ResponseEntity<>(resObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
