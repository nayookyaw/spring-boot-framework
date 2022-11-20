package bisbackend.controllers.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bisbackend.consts.GlobalConst;
import bisbackend.services.login.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    // test
    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    public ResponseEntity<Object> getUser () {
        try {
            return loginService.login();
        } catch (Exception e) {
            HashMap<String, Object> resObj = new HashMap<String, Object>();
            resObj.put("status", GlobalConst.ERROR_CODE);
            resObj.put("message", e.getLocalizedMessage());
            return new ResponseEntity<>(resObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
