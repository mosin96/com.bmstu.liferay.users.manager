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

package com.bmstu.users.manager.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TraccarUserLocalService}.
 *
 * @author Mosin
 * @see TraccarUserLocalService
 * @generated
 */
@ProviderType
public class TraccarUserLocalServiceWrapper implements TraccarUserLocalService,
	ServiceWrapper<TraccarUserLocalService> {
	public TraccarUserLocalServiceWrapper(
		TraccarUserLocalService traccarUserLocalService) {
		_traccarUserLocalService = traccarUserLocalService;
	}

	/**
	* Adds the traccar user to the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was added
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser addTraccarUser(
		com.bmstu.users.manager.model.TraccarUser traccarUser) {
		return _traccarUserLocalService.addTraccarUser(traccarUser);
	}

	@Override
	public com.bmstu.users.manager.model.TraccarUser addTraccarUser(
		long userId, java.lang.String name, java.lang.String password,
		java.lang.String email,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.addTraccarUser(userId, name, password,
			email, serviceContext);
	}

	/**
	* Creates a new traccar user with the primary key. Does not add the traccar user to the database.
	*
	* @param traccarUserId the primary key for the new traccar user
	* @return the new traccar user
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser createTraccarUser(
		long traccarUserId) {
		return _traccarUserLocalService.createTraccarUser(traccarUserId);
	}

	/**
	* Deletes the traccar user from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was removed
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser deleteTraccarUser(
		com.bmstu.users.manager.model.TraccarUser traccarUser) {
		return _traccarUserLocalService.deleteTraccarUser(traccarUser);
	}

	/**
	* Deletes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user that was removed
	* @throws PortalException if a traccar user with the primary key could not be found
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser deleteTraccarUser(
		long traccarUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.deleteTraccarUser(traccarUserId);
	}

	@Override
	public com.bmstu.users.manager.model.TraccarUser deleteTraccarUser(
		long traccarUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.deleteTraccarUser(traccarUserId,
			serviceContext);
	}

	@Override
	public com.bmstu.users.manager.model.TraccarUser fetchTraccarUser(
		long traccarUserId) {
		return _traccarUserLocalService.fetchTraccarUser(traccarUserId);
	}

	/**
	* Returns the traccar user matching the UUID and group.
	*
	* @param uuid the traccar user's UUID
	* @param groupId the primary key of the group
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser fetchTraccarUserByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _traccarUserLocalService.fetchTraccarUserByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the traccar user with the primary key.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user
	* @throws PortalException if a traccar user with the primary key could not be found
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser getTraccarUser(
		long traccarUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.getTraccarUser(traccarUserId);
	}

	/**
	* Returns the traccar user matching the UUID and group.
	*
	* @param uuid the traccar user's UUID
	* @param groupId the primary key of the group
	* @return the matching traccar user
	* @throws PortalException if a matching traccar user could not be found
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser getTraccarUserByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.getTraccarUserByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the traccar user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was updated
	*/
	@Override
	public com.bmstu.users.manager.model.TraccarUser updateTraccarUser(
		com.bmstu.users.manager.model.TraccarUser traccarUser) {
		return _traccarUserLocalService.updateTraccarUser(traccarUser);
	}

	@Override
	public com.bmstu.users.manager.model.TraccarUser updateTraccarUser(
		long userId, long traccarUserId, java.lang.String name,
		java.lang.String password, java.lang.String email,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _traccarUserLocalService.updateTraccarUser(userId,
			traccarUserId, name, password, email, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _traccarUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _traccarUserLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _traccarUserLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _traccarUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _traccarUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of traccar users.
	*
	* @return the number of traccar users
	*/
	@Override
	public int getTraccarUsersCount() {
		return _traccarUserLocalService.getTraccarUsersCount();
	}

	@Override
	public int getTraccarUsersCount(long groupId) {
		return _traccarUserLocalService.getTraccarUsersCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _traccarUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _traccarUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.users.manager.model.impl.TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _traccarUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.users.manager.model.impl.TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _traccarUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the traccar users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.users.manager.model.impl.TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of traccar users
	*/
	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsers(
		int start, int end) {
		return _traccarUserLocalService.getTraccarUsers(start, end);
	}

	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsers(
		long groupId) {
		return _traccarUserLocalService.getTraccarUsers(groupId);
	}

	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsers(
		long groupId, int start, int end) {
		return _traccarUserLocalService.getTraccarUsers(groupId, start, end);
	}

	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsers(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.bmstu.users.manager.model.TraccarUser> obc) {
		return _traccarUserLocalService.getTraccarUsers(groupId, start, end, obc);
	}

	/**
	* Returns all the traccar users matching the UUID and company.
	*
	* @param uuid the UUID of the traccar users
	* @param companyId the primary key of the company
	* @return the matching traccar users, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _traccarUserLocalService.getTraccarUsersByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of traccar users matching the UUID and company.
	*
	* @param uuid the UUID of the traccar users
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching traccar users, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.bmstu.users.manager.model.TraccarUser> getTraccarUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.bmstu.users.manager.model.TraccarUser> orderByComparator) {
		return _traccarUserLocalService.getTraccarUsersByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _traccarUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _traccarUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public TraccarUserLocalService getWrappedService() {
		return _traccarUserLocalService;
	}

	@Override
	public void setWrappedService(
		TraccarUserLocalService traccarUserLocalService) {
		_traccarUserLocalService = traccarUserLocalService;
	}

	private TraccarUserLocalService _traccarUserLocalService;
}