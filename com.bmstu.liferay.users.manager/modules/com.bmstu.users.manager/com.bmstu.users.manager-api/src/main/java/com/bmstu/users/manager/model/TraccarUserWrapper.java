/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bmstu.users.manager.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TraccarUser}.
 * </p>
 *
 * @author Mosin
 * @see TraccarUser
 * @generated
 */
@ProviderType
public class TraccarUserWrapper implements TraccarUser,
	ModelWrapper<TraccarUser> {
	public TraccarUserWrapper(TraccarUser traccarUser) {
		_traccarUser = traccarUser;
	}

	@Override
	public Class<?> getModelClass() {
		return TraccarUser.class;
	}

	@Override
	public String getModelClassName() {
		return TraccarUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("traccarUserId", getTraccarUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("password", getPassword());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long traccarUserId = (Long)attributes.get("traccarUserId");

		if (traccarUserId != null) {
			setTraccarUserId(traccarUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public TraccarUser toEscapedModel() {
		return new TraccarUserWrapper(_traccarUser.toEscapedModel());
	}

	@Override
	public TraccarUser toUnescapedModel() {
		return new TraccarUserWrapper(_traccarUser.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this traccar user is approved.
	*
	* @return <code>true</code> if this traccar user is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _traccarUser.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _traccarUser.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this traccar user is denied.
	*
	* @return <code>true</code> if this traccar user is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _traccarUser.isDenied();
	}

	/**
	* Returns <code>true</code> if this traccar user is a draft.
	*
	* @return <code>true</code> if this traccar user is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _traccarUser.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _traccarUser.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this traccar user is expired.
	*
	* @return <code>true</code> if this traccar user is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _traccarUser.isExpired();
	}

	/**
	* Returns <code>true</code> if this traccar user is inactive.
	*
	* @return <code>true</code> if this traccar user is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _traccarUser.isInactive();
	}

	/**
	* Returns <code>true</code> if this traccar user is incomplete.
	*
	* @return <code>true</code> if this traccar user is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _traccarUser.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _traccarUser.isNew();
	}

	/**
	* Returns <code>true</code> if this traccar user is pending.
	*
	* @return <code>true</code> if this traccar user is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _traccarUser.isPending();
	}

	/**
	* Returns <code>true</code> if this traccar user is scheduled.
	*
	* @return <code>true</code> if this traccar user is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _traccarUser.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _traccarUser.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TraccarUser> toCacheModel() {
		return _traccarUser.toCacheModel();
	}

	@Override
	public int compareTo(TraccarUser traccarUser) {
		return _traccarUser.compareTo(traccarUser);
	}

	/**
	* Returns the status of this traccar user.
	*
	* @return the status of this traccar user
	*/
	@Override
	public int getStatus() {
		return _traccarUser.getStatus();
	}

	@Override
	public int hashCode() {
		return _traccarUser.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _traccarUser.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TraccarUserWrapper((TraccarUser)_traccarUser.clone());
	}

	/**
	* Returns the email of this traccar user.
	*
	* @return the email of this traccar user
	*/
	@Override
	public java.lang.String getEmail() {
		return _traccarUser.getEmail();
	}

	/**
	* Returns the name of this traccar user.
	*
	* @return the name of this traccar user
	*/
	@Override
	public java.lang.String getName() {
		return _traccarUser.getName();
	}

	/**
	* Returns the password of this traccar user.
	*
	* @return the password of this traccar user
	*/
	@Override
	public java.lang.String getPassword() {
		return _traccarUser.getPassword();
	}

	/**
	* Returns the status by user name of this traccar user.
	*
	* @return the status by user name of this traccar user
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _traccarUser.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this traccar user.
	*
	* @return the status by user uuid of this traccar user
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _traccarUser.getStatusByUserUuid();
	}

	/**
	* Returns the traccar user uuid of this traccar user.
	*
	* @return the traccar user uuid of this traccar user
	*/
	@Override
	public java.lang.String getTraccarUserUuid() {
		return _traccarUser.getTraccarUserUuid();
	}

	/**
	* Returns the user name of this traccar user.
	*
	* @return the user name of this traccar user
	*/
	@Override
	public java.lang.String getUserName() {
		return _traccarUser.getUserName();
	}

	/**
	* Returns the user uuid of this traccar user.
	*
	* @return the user uuid of this traccar user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _traccarUser.getUserUuid();
	}

	/**
	* Returns the uuid of this traccar user.
	*
	* @return the uuid of this traccar user
	*/
	@Override
	public java.lang.String getUuid() {
		return _traccarUser.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _traccarUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _traccarUser.toXmlString();
	}

	/**
	* Returns the create date of this traccar user.
	*
	* @return the create date of this traccar user
	*/
	@Override
	public Date getCreateDate() {
		return _traccarUser.getCreateDate();
	}

	/**
	* Returns the modified date of this traccar user.
	*
	* @return the modified date of this traccar user
	*/
	@Override
	public Date getModifiedDate() {
		return _traccarUser.getModifiedDate();
	}

	/**
	* Returns the status date of this traccar user.
	*
	* @return the status date of this traccar user
	*/
	@Override
	public Date getStatusDate() {
		return _traccarUser.getStatusDate();
	}

	/**
	* Returns the company ID of this traccar user.
	*
	* @return the company ID of this traccar user
	*/
	@Override
	public long getCompanyId() {
		return _traccarUser.getCompanyId();
	}

	/**
	* Returns the group ID of this traccar user.
	*
	* @return the group ID of this traccar user
	*/
	@Override
	public long getGroupId() {
		return _traccarUser.getGroupId();
	}

	/**
	* Returns the primary key of this traccar user.
	*
	* @return the primary key of this traccar user
	*/
	@Override
	public long getPrimaryKey() {
		return _traccarUser.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this traccar user.
	*
	* @return the status by user ID of this traccar user
	*/
	@Override
	public long getStatusByUserId() {
		return _traccarUser.getStatusByUserId();
	}

	/**
	* Returns the traccar user ID of this traccar user.
	*
	* @return the traccar user ID of this traccar user
	*/
	@Override
	public long getTraccarUserId() {
		return _traccarUser.getTraccarUserId();
	}

	/**
	* Returns the user ID of this traccar user.
	*
	* @return the user ID of this traccar user
	*/
	@Override
	public long getUserId() {
		return _traccarUser.getUserId();
	}

	@Override
	public void persist() {
		_traccarUser.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_traccarUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this traccar user.
	*
	* @param companyId the company ID of this traccar user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_traccarUser.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this traccar user.
	*
	* @param createDate the create date of this traccar user
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_traccarUser.setCreateDate(createDate);
	}

	/**
	* Sets the email of this traccar user.
	*
	* @param email the email of this traccar user
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_traccarUser.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_traccarUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_traccarUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_traccarUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this traccar user.
	*
	* @param groupId the group ID of this traccar user
	*/
	@Override
	public void setGroupId(long groupId) {
		_traccarUser.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this traccar user.
	*
	* @param modifiedDate the modified date of this traccar user
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_traccarUser.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this traccar user.
	*
	* @param name the name of this traccar user
	*/
	@Override
	public void setName(java.lang.String name) {
		_traccarUser.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_traccarUser.setNew(n);
	}

	/**
	* Sets the password of this traccar user.
	*
	* @param password the password of this traccar user
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_traccarUser.setPassword(password);
	}

	/**
	* Sets the primary key of this traccar user.
	*
	* @param primaryKey the primary key of this traccar user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_traccarUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_traccarUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this traccar user.
	*
	* @param status the status of this traccar user
	*/
	@Override
	public void setStatus(int status) {
		_traccarUser.setStatus(status);
	}

	/**
	* Sets the status by user ID of this traccar user.
	*
	* @param statusByUserId the status by user ID of this traccar user
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_traccarUser.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this traccar user.
	*
	* @param statusByUserName the status by user name of this traccar user
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_traccarUser.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this traccar user.
	*
	* @param statusByUserUuid the status by user uuid of this traccar user
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_traccarUser.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this traccar user.
	*
	* @param statusDate the status date of this traccar user
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_traccarUser.setStatusDate(statusDate);
	}

	/**
	* Sets the traccar user ID of this traccar user.
	*
	* @param traccarUserId the traccar user ID of this traccar user
	*/
	@Override
	public void setTraccarUserId(long traccarUserId) {
		_traccarUser.setTraccarUserId(traccarUserId);
	}

	/**
	* Sets the traccar user uuid of this traccar user.
	*
	* @param traccarUserUuid the traccar user uuid of this traccar user
	*/
	@Override
	public void setTraccarUserUuid(java.lang.String traccarUserUuid) {
		_traccarUser.setTraccarUserUuid(traccarUserUuid);
	}

	/**
	* Sets the user ID of this traccar user.
	*
	* @param userId the user ID of this traccar user
	*/
	@Override
	public void setUserId(long userId) {
		_traccarUser.setUserId(userId);
	}

	/**
	* Sets the user name of this traccar user.
	*
	* @param userName the user name of this traccar user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_traccarUser.setUserName(userName);
	}

	/**
	* Sets the user uuid of this traccar user.
	*
	* @param userUuid the user uuid of this traccar user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_traccarUser.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this traccar user.
	*
	* @param uuid the uuid of this traccar user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_traccarUser.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TraccarUserWrapper)) {
			return false;
		}

		TraccarUserWrapper traccarUserWrapper = (TraccarUserWrapper)obj;

		if (Objects.equals(_traccarUser, traccarUserWrapper._traccarUser)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _traccarUser.getStagedModelType();
	}

	@Override
	public TraccarUser getWrappedModel() {
		return _traccarUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _traccarUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _traccarUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_traccarUser.resetOriginalValues();
	}

	private final TraccarUser _traccarUser;
}