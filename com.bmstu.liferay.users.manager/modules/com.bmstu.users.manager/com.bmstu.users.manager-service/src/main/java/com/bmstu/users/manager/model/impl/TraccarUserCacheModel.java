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

package com.bmstu.users.manager.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.users.manager.model.TraccarUser;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TraccarUser in entity cache.
 *
 * @author Mosin
 * @see TraccarUser
 * @generated
 */
@ProviderType
public class TraccarUserCacheModel implements CacheModel<TraccarUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TraccarUserCacheModel)) {
			return false;
		}

		TraccarUserCacheModel traccarUserCacheModel = (TraccarUserCacheModel)obj;

		if (traccarUserId == traccarUserCacheModel.traccarUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, traccarUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", traccarUserId=");
		sb.append(traccarUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", password=");
		sb.append(password);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TraccarUser toEntityModel() {
		TraccarUserImpl traccarUserImpl = new TraccarUserImpl();

		if (uuid == null) {
			traccarUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setUuid(uuid);
		}

		traccarUserImpl.setTraccarUserId(traccarUserId);
		traccarUserImpl.setGroupId(groupId);
		traccarUserImpl.setCompanyId(companyId);
		traccarUserImpl.setUserId(userId);

		if (userName == null) {
			traccarUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			traccarUserImpl.setCreateDate(null);
		}
		else {
			traccarUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			traccarUserImpl.setModifiedDate(null);
		}
		else {
			traccarUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		traccarUserImpl.setStatus(status);
		traccarUserImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			traccarUserImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			traccarUserImpl.setStatusDate(null);
		}
		else {
			traccarUserImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			traccarUserImpl.setName(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setName(name);
		}

		if (password == null) {
			traccarUserImpl.setPassword(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setPassword(password);
		}

		if (email == null) {
			traccarUserImpl.setEmail(StringPool.BLANK);
		}
		else {
			traccarUserImpl.setEmail(email);
		}

		traccarUserImpl.resetOriginalValues();

		return traccarUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		traccarUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		password = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(traccarUserId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public String uuid;
	public long traccarUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String password;
	public String email;
}