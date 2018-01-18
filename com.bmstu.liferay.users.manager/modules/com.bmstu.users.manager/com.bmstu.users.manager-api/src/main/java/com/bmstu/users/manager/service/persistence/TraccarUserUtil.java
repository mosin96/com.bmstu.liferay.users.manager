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

package com.bmstu.users.manager.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.users.manager.model.TraccarUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the traccar user service. This utility wraps {@link com.bmstu.users.manager.service.persistence.impl.TraccarUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mosin
 * @see TraccarUserPersistence
 * @see com.bmstu.users.manager.service.persistence.impl.TraccarUserPersistenceImpl
 * @generated
 */
@ProviderType
public class TraccarUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TraccarUser traccarUser) {
		getPersistence().clearCache(traccarUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TraccarUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraccarUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraccarUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TraccarUser update(TraccarUser traccarUser) {
		return getPersistence().update(traccarUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TraccarUser update(TraccarUser traccarUser,
		ServiceContext serviceContext) {
		return getPersistence().update(traccarUser, serviceContext);
	}

	/**
	* Returns all the traccar users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching traccar users
	*/
	public static List<TraccarUser> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the traccar users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the traccar users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the traccar users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByUuid_First(java.lang.String uuid,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByUuid_Last(java.lang.String uuid,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the traccar users before and after the current traccar user in the ordered set where uuid = &#63;.
	*
	* @param traccarUserId the primary key of the current traccar user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public static TraccarUser[] findByUuid_PrevAndNext(long traccarUserId,
		java.lang.String uuid, OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(traccarUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the traccar users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of traccar users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching traccar users
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTraccarUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByUUID_G(java.lang.String uuid, long groupId)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the traccar user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the traccar user that was removed
	*/
	public static TraccarUser removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of traccar users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching traccar users
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the traccar users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching traccar users
	*/
	public static List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the traccar users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the traccar users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the traccar users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the traccar users before and after the current traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param traccarUserId the primary key of the current traccar user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public static TraccarUser[] findByUuid_C_PrevAndNext(long traccarUserId,
		java.lang.String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(traccarUserId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the traccar users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of traccar users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching traccar users
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the traccar users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching traccar users
	*/
	public static List<TraccarUser> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the traccar users where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of matching traccar users
	*/
	public static List<TraccarUser> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the traccar users where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByGroupId(long groupId, int start,
		int end, OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the traccar users where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByGroupId(long groupId, int start,
		int end, OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByGroupId_First(long groupId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByGroupId_First(long groupId,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByGroupId_Last(long groupId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByGroupId_Last(long groupId,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the traccar users before and after the current traccar user in the ordered set where groupId = &#63;.
	*
	* @param traccarUserId the primary key of the current traccar user
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public static TraccarUser[] findByGroupId_PrevAndNext(long traccarUserId,
		long groupId, OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(traccarUserId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the traccar users where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of traccar users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching traccar users
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the traccar users where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @return the matching traccar users
	*/
	public static List<TraccarUser> findByTraccarUserId(long traccarUserId) {
		return getPersistence().findByTraccarUserId(traccarUserId);
	}

	/**
	* Returns a range of all the traccar users where traccarUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param traccarUserId the traccar user ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of matching traccar users
	*/
	public static List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end) {
		return getPersistence().findByTraccarUserId(traccarUserId, start, end);
	}

	/**
	* Returns an ordered range of all the traccar users where traccarUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param traccarUserId the traccar user ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .findByTraccarUserId(traccarUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the traccar users where traccarUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param traccarUserId the traccar user ID
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching traccar users
	*/
	public static List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTraccarUserId(traccarUserId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByTraccarUserId_First(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByTraccarUserId_First(traccarUserId, orderByComparator);
	}

	/**
	* Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByTraccarUserId_First(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .fetchByTraccarUserId_First(traccarUserId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public static TraccarUser findByTraccarUserId_Last(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence()
				   .findByTraccarUserId_Last(traccarUserId, orderByComparator);
	}

	/**
	* Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public static TraccarUser fetchByTraccarUserId_Last(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence()
				   .fetchByTraccarUserId_Last(traccarUserId, orderByComparator);
	}

	/**
	* Removes all the traccar users where traccarUserId = &#63; from the database.
	*
	* @param traccarUserId the traccar user ID
	*/
	public static void removeByTraccarUserId(long traccarUserId) {
		getPersistence().removeByTraccarUserId(traccarUserId);
	}

	/**
	* Returns the number of traccar users where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @return the number of matching traccar users
	*/
	public static int countByTraccarUserId(long traccarUserId) {
		return getPersistence().countByTraccarUserId(traccarUserId);
	}

	/**
	* Caches the traccar user in the entity cache if it is enabled.
	*
	* @param traccarUser the traccar user
	*/
	public static void cacheResult(TraccarUser traccarUser) {
		getPersistence().cacheResult(traccarUser);
	}

	/**
	* Caches the traccar users in the entity cache if it is enabled.
	*
	* @param traccarUsers the traccar users
	*/
	public static void cacheResult(List<TraccarUser> traccarUsers) {
		getPersistence().cacheResult(traccarUsers);
	}

	/**
	* Creates a new traccar user with the primary key. Does not add the traccar user to the database.
	*
	* @param traccarUserId the primary key for the new traccar user
	* @return the new traccar user
	*/
	public static TraccarUser create(long traccarUserId) {
		return getPersistence().create(traccarUserId);
	}

	/**
	* Removes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user that was removed
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public static TraccarUser remove(long traccarUserId)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().remove(traccarUserId);
	}

	public static TraccarUser updateImpl(TraccarUser traccarUser) {
		return getPersistence().updateImpl(traccarUser);
	}

	/**
	* Returns the traccar user with the primary key or throws a {@link NoSuchTraccarUserException} if it could not be found.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public static TraccarUser findByPrimaryKey(long traccarUserId)
		throws com.bmstu.users.manager.exception.NoSuchTraccarUserException {
		return getPersistence().findByPrimaryKey(traccarUserId);
	}

	/**
	* Returns the traccar user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user, or <code>null</code> if a traccar user with the primary key could not be found
	*/
	public static TraccarUser fetchByPrimaryKey(long traccarUserId) {
		return getPersistence().fetchByPrimaryKey(traccarUserId);
	}

	public static java.util.Map<java.io.Serializable, TraccarUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the traccar users.
	*
	* @return the traccar users
	*/
	public static List<TraccarUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the traccar users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @return the range of traccar users
	*/
	public static List<TraccarUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the traccar users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of traccar users
	*/
	public static List<TraccarUser> findAll(int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the traccar users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TraccarUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of traccar users
	* @param end the upper bound of the range of traccar users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of traccar users
	*/
	public static List<TraccarUser> findAll(int start, int end,
		OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the traccar users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of traccar users.
	*
	* @return the number of traccar users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TraccarUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TraccarUserPersistence, TraccarUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TraccarUserPersistence.class);
}