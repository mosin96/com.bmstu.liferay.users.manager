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

package com.bmstu.users.manager.service.impl;

import java.util.Date;
import java.util.List;

import com.bmstu.users.manager.exception.TraccarUserEmailException;
import com.bmstu.users.manager.exception.TraccarUserNameException;
import com.bmstu.users.manager.exception.TraccarUserPasswordException;
import com.bmstu.users.manager.model.TraccarUser;
import com.bmstu.users.manager.service.base.TraccarUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the traccar user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.bmstu.users.manager.service.TraccarUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Mosin
 * @see TraccarUserLocalServiceBaseImpl
 * @see com.bmstu.users.manager.service.TraccarUserLocalServiceUtil
 */
public class TraccarUserLocalServiceImpl extends TraccarUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.bmstu.users.manager.service.TraccarUserLocalServiceUtil} to access
	 * the traccar user local service.
	 */

	@Override
	public TraccarUser addTraccarUser(long userId, String name, String password, String email,
			ServiceContext serviceContext) throws PortalException {
		validate(name, password, email);

		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);
		Date currentDate = new Date();

		long traccarUserId = counterLocalService.increment();
		TraccarUser traccarUser = traccarUserPersistence.create(traccarUserId);

		traccarUser.setUuid(serviceContext.getUuid());
		traccarUser.setUserId(userId);
		traccarUser.setGroupId(groupId);
		traccarUser.setCompanyId(user.getCompanyId());
		traccarUser.setUserName(user.getFullName());
		traccarUser.setCreateDate(serviceContext.getCreateDate(currentDate));
		traccarUser.setModifiedDate(serviceContext.getModifiedDate(currentDate));
		traccarUser.setName(name);
		traccarUser.setPassword(password);
		traccarUser.setEmail(email);
		traccarUser.setExpandoBridgeAttributes(serviceContext);

		traccarUserPersistence.update(traccarUser);

		return traccarUser;

	}

	@Override
	public TraccarUser updateTraccarUser(long userId, long traccarUserId, String name, String password, String email,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Date currentDate = new Date();

		validate(name, password, email);

		TraccarUser traccarUser = getTraccarUser(traccarUserId);
		User user = userLocalService.getUserById(userId);

		traccarUser.setUserId(userId);
		traccarUser.setUserName(user.getFullName());
		traccarUser.setModifiedDate(serviceContext.getModifiedDate(currentDate));
		traccarUser.setName(name);
		traccarUser.setPassword(password);
		traccarUser.setEmail(email);
		traccarUser.setExpandoBridgeAttributes(serviceContext);

		traccarUserPersistence.update(traccarUser);

		return traccarUser;
	}

	@Override
	public TraccarUser deleteTraccarUser(long traccarUserId, ServiceContext serviceContext) throws PortalException {
		TraccarUser traccarUser = getTraccarUser(traccarUserId);
		traccarUser = deleteTraccarUser(traccarUserId);

		return traccarUser;
	}

	@Override
	public List<TraccarUser> getTraccarUsers(long groupId) {
		return traccarUserPersistence.findByGroupId(groupId);
	}

	@Override
	public List<TraccarUser> getTraccarUsers(long groupId, int start, int end, OrderByComparator<TraccarUser> obc) {

		return traccarUserPersistence.findByGroupId(groupId, start, end, obc);
	}

	@Override
	public List<TraccarUser> getTraccarUsers(long groupId, int start, int end) {

		return traccarUserPersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public int getTraccarUsersCount(long groupId) {

		return traccarUserPersistence.countByGroupId(groupId);
	}

	private void validate(String name, String password, String email) throws PortalException {
		validateName(name);
		validatePassword(password);
		validateEmail(email);
	}

	private void validateName(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new TraccarUserNameException();
		}
	}

	private void validatePassword(String password) throws PortalException {
		if (Validator.isNull(password)) {
			throw new TraccarUserPasswordException();
		}
	}

	private void validateEmail(String email) throws PortalException {
		if (Validator.isNull(email)) {
			throw new TraccarUserEmailException();
		}
	}
}