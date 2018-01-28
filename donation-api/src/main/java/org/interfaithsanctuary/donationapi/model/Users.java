package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity // This tells Hibernate to make a table out of this class
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name ="permissions")
    private PermissionLevel permissions;

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String email) {
        this.userEmail = email;
    }

    public String getPassword() { return userPassword; }

    public void setPassword(String password) {
        this.userPassword = password;

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //this.user_password = passwordEncoder.encode(password);
    }

    public PermissionLevel getPermissions() { return permissions; }

    public void setPermissions(PermissionLevel permissions) { this.permissions = permissions; }



    /**
     *
     */
    public static enum PermissionLevel{
        BASIC_USER("basic", 1),
        ADMINISTRATOR("admin", 0),
        FAILED_AUTHENTICATION("invalid", -1);

        private final int id;
        private final String name;
        PermissionLevel(String name, int id){
            this.id = id;
            this.name = name;
        }

        public int getId(){
            return id;
        }

        public PermissionLevel getByid(int id){
            for(PermissionLevel level : PermissionLevel.values()){
                if(level.getId()== id)return level;
            }
            throw new IllegalArgumentException(String.format("There is no permission for id: %s", id));
        }

        public static PermissionLevel getById(int id){
            for(PermissionLevel level : PermissionLevel.values()){
                if(level.getId() == id){
                    return level;
                }
            }
            return null;
        }
    }




}