package com.sunny.SmartFinTrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must contain at least 8 characters, including at least one digit, one lowercase letter," +
                    " one uppercase letter, one special character, and no whitespace.")
    private String password;


    public UserEntity() {
    }

    public UserEntity(long userId, String name, String email, String phone, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ExpenseEntity>expenseEntities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<EstimateEntity>estimateEntities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<NotificationEntity>notificationEntities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MessageEntity>messageEntities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<FileUploadEntity>fileUploadsEntities;

}
