package bisbackend.services.login;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import bisbackend.consts.GlobalConst;

@Service
public class LoginService implements LoginServiceInterface {
    
    public ResponseEntity<Object> login () {
        HashMap<String, Object> resObj = new HashMap<String, Object>();

        resObj.put("status", GlobalConst.SUCCESS_CODE);
        resObj.put("data", null);

        return new ResponseEntity<Object>(resObj, HttpStatus.OK);
    }
}
