package core;

import java.util.Objects;

public class UserDetails {
    private String userName;
    private String fullName;
    private String sessionToken;

    public UserDetails(String userName, String fullName, String sessionToken) {
        this.userName = userName;
        this.fullName = fullName;
        this.sessionToken = sessionToken;
    }

    public UserDetails() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails userDetails = (UserDetails) o;
        return Objects.equals(userName, userDetails.userName) &&
                Objects.equals(fullName, userDetails.fullName) &&
                Objects.equals(sessionToken, userDetails.sessionToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, fullName, sessionToken);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }
}
