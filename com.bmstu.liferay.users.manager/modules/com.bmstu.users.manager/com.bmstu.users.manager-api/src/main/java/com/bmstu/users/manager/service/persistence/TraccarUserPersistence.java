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

import com.bmstu.users.manager.exception.NoSuchTraccarUserException;
import com.bmstu.users.manager.model.TraccarUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the traccar user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mosin
 * @see com.bmstu.users.manager.service.persistence.impl.TraccarUserPersistenceImpl
 * @see TraccarUserUtil
 * @generated
 */
@ProviderType
public interface TraccarUserPersistence extends BasePersistence<TraccarUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraccarUserUtil} to access the traccar user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the traccar users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching traccar users
	*/
	public java.util.List<TraccarUser> findByUuid(java.lang.String uuid);

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
	public java.util.List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public java.util.List<TraccarUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the traccar users before and after the current traccar user in the ordered set where uuid = &#63;.
	*
	* @param traccarUserId the primary key of the current traccar user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public TraccarUser[] findByUuid_PrevAndNext(long traccarUserId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Removes all the traccar users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of traccar users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching traccar users
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTraccarUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTraccarUserException;

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the traccar user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the traccar user that was removed
	*/
	public TraccarUser removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchTraccarUserException;

	/**
	* Returns the number of traccar users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching traccar users
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the traccar users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching traccar users
	*/
	public java.util.List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public java.util.List<TraccarUser> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the first traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the last traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public TraccarUser[] findByUuid_C_PrevAndNext(long traccarUserId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Removes all the traccar users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of traccar users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching traccar users
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the traccar users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching traccar users
	*/
	public java.util.List<TraccarUser> findByGroupId(long groupId);

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
	public java.util.List<TraccarUser> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<TraccarUser> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public java.util.List<TraccarUser> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the first traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the last traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the last traccar user in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the traccar users before and after the current traccar user in the ordered set where groupId = &#63;.
	*
	* @param traccarUserId the primary key of the current traccar user
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public TraccarUser[] findByGroupId_PrevAndNext(long traccarUserId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Removes all the traccar users where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of traccar users where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching traccar users
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the traccar users where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @return the matching traccar users
	*/
	public java.util.List<TraccarUser> findByTraccarUserId(long traccarUserId);

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
	public java.util.List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end);

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
	public java.util.List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public java.util.List<TraccarUser> findByTraccarUserId(long traccarUserId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByTraccarUserId_First(long traccarUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByTraccarUserId_First(long traccarUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user
	* @throws NoSuchTraccarUserException if a matching traccar user could not be found
	*/
	public TraccarUser findByTraccarUserId_Last(long traccarUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException;

	/**
	* Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	*/
	public TraccarUser fetchByTraccarUserId_Last(long traccarUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

	/**
	* Removes all the traccar users where traccarUserId = &#63; from the database.
	*
	* @param traccarUserId the traccar user ID
	*/
	public void removeByTraccarUserId(long traccarUserId);

	/**
	* Returns the number of traccar users where traccarUserId = &#63;.
	*
	* @param traccarUserId the traccar user ID
	* @return the number of matching traccar users
	*/
	public int countByTraccarUserId(long traccarUserId);

	/**
	* Caches the traccar user in the entity cache if it is enabled.
	*
	* @param traccarUser the traccar user
	*/
	public void cacheResult(TraccarUser traccarUser);

	/**
	* Caches the traccar users in the entity cache if it is enabled.
	*
	* @param traccarUsers the traccar users
	*/
	public void cacheResult(java.util.List<TraccarUser> traccarUsers);

	/**
	* Creates a new traccar user with the primary key. Does not add the traccar user to the database.
	*
	* @param traccarUserId the primary key for the new traccar user
	* @return the new traccar user
	*/
	public TraccarUser create(long traccarUserId);

	/**
	* Removes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user that was removed
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public TraccarUser remove(long traccarUserId)
		throws NoSuchTraccarUserException;

	public TraccarUser updateImpl(TraccarUser traccarUser);

	/**
	* Returns the traccar user with the primary key or throws a {@link NoSuchTraccarUserException} if it could not be found.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user
	* @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	*/
	public TraccarUser findByPrimaryKey(long traccarUserId)
		throws NoSuchTraccarUserException;

	/**
	* Returns the traccar user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param traccarUserId the primary key of the traccar user
	* @return the traccar user, or <code>null</code> if a traccar user with the primary key could not be found
	*/
	public TraccarUser fetchByPrimaryKey(long traccarUserId);

	@Override
	public java.util.Map<java.io.Serializable, TraccarUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the traccar users.
	*
	* @return the traccar users
	*/
	public java.util.List<TraccarUser> findAll();

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
	public java.util.List<TraccarUser> findAll(int start, int end);

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
	public java.util.List<TraccarUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator);

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
	public java.util.List<TraccarUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the traccar users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of traccar users.
	*
	* @return the number of traccar users
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}