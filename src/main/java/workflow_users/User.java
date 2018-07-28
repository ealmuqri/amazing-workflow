package workflow_users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String
            id,
            name,
            email,
            mobile,
            phone,
            position,
            title;
    private User manager;
    
    private UserInbox userInbox;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public UserInbox getUserInbox() {
        return userInbox;
    }

    public void setUserInbox(UserInbox userInbox) {
        this.userInbox = userInbox;
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        userInbox = new UserInbox();
    }
}
