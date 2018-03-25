package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name ="permissions")
    private PermissionLevel permissions;

    @Column(name ="user_active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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