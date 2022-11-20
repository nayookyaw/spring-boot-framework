package bisbackend.models.user;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String userName;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    public HashMap<String, Object> toResponse() {
        HashMap<String, Object> resObj = new HashMap<String, Object>();
        resObj.put("id", this.id);
        resObj.put("userName", this.userName);
        resObj.put("name", this.name);
        resObj.put("email", this.email);

        return resObj;
    }
}
