package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class User {
    Long userId;
    String userName;
    List<Long> follows = new ArrayList<>();
    Boolean isActive;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getFollows() {
        return this.follows;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFollows(List<Long> follows) {
        this.follows = follows;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getUserName() {
        return this.userName;
    }
}
