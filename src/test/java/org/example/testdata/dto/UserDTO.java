package org.example.testdata.dto;

public class UserDTO {

    private String userId;
    private String userEmail;
    private String userPassword;

    public UserDTO withUserId(String userId){
        setUserId(userId);
        return this;
    }

    public UserDTO withUserEmail(String userEmail){
        setUserEmail(userEmail);
        return this;
    }

    public UserDTO withUserPassword(String userPassword){
        setUserPassword(userPassword);
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
