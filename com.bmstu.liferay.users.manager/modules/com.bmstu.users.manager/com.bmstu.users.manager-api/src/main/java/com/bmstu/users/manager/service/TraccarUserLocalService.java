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

import com.bmstu.users.manager.model.TraccarUser;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TraccarUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mosin
 * @see TraccarUserLocalServiceUtil
 * @see com.bmstu.users.manager.service.base.TraccarUserLocalServiceBaseImpl
 * @see com.bmstu.users.manager.service.impl.TraccarUserLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TraccarUserLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraccarUserLocalServiceUtil} to access the traccar user local service. Add custom service methods to {@link com.bmstu.users.manager.service.impl.TraccarUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the traccar user to the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TraccarUser addTraccarUser(TraccarUser traccarUser);

	public TraccarUser addTraccarUser(long userId, java.lang.String name,
		java.lang.String password, java.lang.String email,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new traccar user with the primary key. Does not add the traccar user to the database.
	*
	* @param traccarUserId the primary key for the new traccar user
	* @return the new traccar user
	*/
	public TraccarUser createTraccarUser(long traccarUserId);

	/**
	* Deletes the traccar user from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TraccarUser deleteTraccarUser(TraccarUser traccarUser);

	/**
	* Deletes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user that was removed
	* @throws PortalException if a traccar user with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TraccarUser deleteTraccarUser(long traccarUserId)
		throws PortalException;

	public TraccarUser deleteTraccarUser(long traccarUserId,
		ServiceContext serviceContext) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraccarUser fetchTraccarUser(long traccarUserId);

	/**
	* Returns the traccar user matching the UUID and group.
	*
	* @param uuid the traccar user's UUID
	* @param groupId the primary key of the group
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraccarUser fetchTraccarUserByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the traccar user with the primary key.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user
	* @throws PortalException if a traccar user with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraccarUser getTraccarUser(long traccarUserId)
		throws PortalException;

	/**
	* Returns the traccar user matching the UUID and group.
	*
	* @param uuid the traccar user's UUID
	* @param groupId the primary key of the group
	* @return the matching traccar user
	* @throws PortalException if a matching traccar user could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TraccarUser getTraccarUserByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the traccar user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param traccarUser the traccar user
	* @return the traccar user that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TraccarUser updateTraccarUser(TraccarUser traccarUser);

	public TraccarUser updateTraccarUser(long userId, long traccarUserId,
		java.lang.String name, java.lang.String password,
		java.lang.String email, ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of traccar users.
	*
	* @return the number of traccar users
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTraccarUsersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTraccarUsersCount(long groupId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsers(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsers(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsers(long groupId, int start, int end,
		OrderByComparator<TraccarUser> obc);

	/**
	* Returns all the traccar users matching the UUID and company.
	*
	* @param uuid the UUID of the traccar users
	* @param companyId the primary key of the company
	* @return the matching traccar users, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TraccarUser> getTraccarUsersByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}