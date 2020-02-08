package pl.coderslab.gabinet_fizjoterapii.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PersonDTO {

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}