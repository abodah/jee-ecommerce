package org.jee.ecommerce.user.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.jee.ecommerce.user.ERole;

public class Role {

	private Long id;
	private String roleName;

	@Enumerated(EnumType.STRING)
	private ERole type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public ERole getType() {
		return type;
	}

	public void setType(ERole type) {
		this.type = type;
	}

}
