package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByUuid", query="SELECT u FROM User u where u.userUuid = :uuid"),
	@NamedQuery(name="User.findByEmailAndPassword", query="SELECT u FROM User u where LOWER(u.email) = LOWER(:email) AND u.uid = :password")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Lob
	private String additional;

	@Column(name="check_hash")
	private String checkHash;

	@Column(name="create_time")
	private Timestamp createTime;

	private String email;

	@Column(name="is_verify")
	private byte isVerify;

	private String network;

	@Column(name="new_password")
	private String newPassword;

	@Column(name="time_zone")
	private byte timeZone;

	private String uid;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_uuid")
	private String userUuid;

	//uni-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_roles"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	//uni-directional many-to-one association to UserKey
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_key_id")
	private UserKey userKey;

	@Column(name="last_login_time")
	private Timestamp lastLoginTime;
	
	@Column(name="prev_login_time")
	private Timestamp prevLoginTime;
	
	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdditional() {
		return this.additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getCheckHash() {
		return this.checkHash;
	}

	public void setCheckHash(String checkHash) {
		this.checkHash = checkHash;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsVerify() {
		return this.isVerify;
	}

	public void setIsVerify(byte isVerify) {
		this.isVerify = isVerify;
	}

	public String getNetwork() {
		return this.network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public byte getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(byte timeZone) {
		this.timeZone = timeZone;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserUuid() {
		return this.userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public UserKey getUserKey() {
		return this.userKey;
	}

	public void setUserKey(UserKey userKey) {
		this.userKey = userKey;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getPrevLoginTime() {
		return prevLoginTime;
	}

	public void setPrevLoginTime(Timestamp prevLoginTime) {
		this.prevLoginTime = prevLoginTime;
	}

	
}