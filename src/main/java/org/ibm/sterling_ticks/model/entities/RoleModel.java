package org.ibm.sterling_ticks.model.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "role")
public class RoleModel {
	
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role", length = 30, nullable = false)
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private Set<UserModel> users;
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Set<UserModel> users) {
		this.users = users;
	}
}
