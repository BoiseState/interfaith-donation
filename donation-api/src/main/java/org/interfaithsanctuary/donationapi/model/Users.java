package org.interfaithsanctuary.donationapi.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity // This tells Hibernate to make a table out of this class
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_email")
    private String user_email;

    @Column(name ="permissions")
    private PermissionLevel permissions;

    public Integer getId() {
        return user_id;
    }

    public void setId(Integer id) {
        this.user_id = id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String name) {
        this.user_name = name;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }

    public String getPassword() { return user_password; }

    public void setPassword(String password) {
        this.user_password = password;

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