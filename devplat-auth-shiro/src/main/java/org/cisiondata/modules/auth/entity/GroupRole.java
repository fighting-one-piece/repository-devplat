package org.cisiondata.modules.auth.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.cisiondata.modules.abstr.entity.PKAutoEntity;

@Entity
@Table(name="T_GROUP_ROLE")
public class GroupRole extends PKAutoEntity<Long> {

	private static final long serialVersionUID = 1L;

	/** 组ID */
	@ManyToOne(cascade=CascadeType.REFRESH, optional=true)
	@JoinColumn(name="GROUP_ID")
	private Group group = null;
	/** 角色ID */
	@ManyToOne(cascade=CascadeType.REFRESH, optional=true)
	@JoinColumn(name="ROLE_ID")
	private Role role = null;
	/** 优先权*/
	@Column(name="PRIORITY")
	private String priority = null;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
