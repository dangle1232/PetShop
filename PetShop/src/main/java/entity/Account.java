/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {
    private String userId;
    private String userName;
    private String pass;
    private String accountName;
    private int roleId;
    private String userImg;

    public Account() {
    }

    
    public Account(String userId, String userName, String pass, String accountName, int roleId, String userImg) {
        this.userId = userId;
        this.userName = userName;
        this.pass = pass;
        this.accountName = accountName;
        this.roleId = roleId;
        this.userImg = userImg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", userName=" + userName + ", pass=" + pass + ", accountName=" + accountName + ", roleId=" + roleId + ", userImg=" + userImg + '}';
    }
}
