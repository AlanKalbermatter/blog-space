package com.hardkode.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "User")
@Table(name = "book")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_name",
            nullable = false
    )
    private String userName;

    @Column(
            name = "email",
            nullable = false
    )
    @Email(message = "Email should be valid")
    private String email;

    @OneToOne
    @JoinColumn(name = "personal_info",
    nullable = false,
    referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "user_personal_info"))
    private PersonalInfo personalInfo;

    @Column(
            name = "password",
            nullable = false
    )
    @NotNull
    @Size(min = 8, max = 30,
    message="Password must be between 8 and 30 characters")
    private String password;

    public User(String userName, String email, PersonalInfo personalInfo) {
        this.userName = userName;
        this.email = email;
        this.personalInfo = personalInfo;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id= " + id +
                ", userName= '" + userName + '\'' +
                ", email= '" + email + '\'' +
                ", personalInfo= [" + personalInfo.toString() +
                ", password= '" + password + '\'' +
                '}';
    }
}
