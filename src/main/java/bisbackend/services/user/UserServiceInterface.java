package bisbackend.services.user;

import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    ResponseEntity<Object> getUser();
    ResponseEntity<Object> getUserList();
}
