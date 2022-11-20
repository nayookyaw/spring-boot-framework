package bisbackend.dao.user;

import java.util.List;

import jakarta.persistence.Tuple;

public interface UserDaoInterface {
    Tuple getUser();
    List<Tuple> getUserList();
}
