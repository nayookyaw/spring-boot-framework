package bisbackend.services.login;

import org.springframework.http.ResponseEntity;

public interface LoginServiceInterface {
    ResponseEntity<Object> login();
}
