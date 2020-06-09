package be.mobyus.ie5.entities;

public class Password {
    private String passwordValue;

    public Password(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }
}
