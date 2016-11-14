package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_keys database table.
 * 
 */
@Entity
@Table(name="user_keys")
@NamedQuery(name="UserKey.findAll", query="SELECT u FROM UserKey u")
public class UserKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_key_id")
	private int userKeyId;

	@Column(name="create_time")
	private Timestamp createTime;

	@Lob
	@Column(name="private_key")
	private String privateKey;

	@Lob
	@Column(name="public_key")
	private String publicKey;

	@Column(name="update_time")
	private Timestamp updateTime;

	@OneToOne(mappedBy="userKey")
	private User user;
	
	public UserKey() {
	}

	public int getUserKeyId() {
		return this.userKeyId;
	}

	public void setUserKeyId(int userKeyId) {
		this.userKeyId = userKeyId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getPrivateKey() {
		return this.privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return this.publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}