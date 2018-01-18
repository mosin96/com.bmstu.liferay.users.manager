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

package com.bmstu.users.manager.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.users.manager.exception.NoSuchTraccarUserException;
import com.bmstu.users.manager.model.TraccarUser;
import com.bmstu.users.manager.model.impl.TraccarUserImpl;
import com.bmstu.users.manager.model.impl.TraccarUserModelImpl;
import com.bmstu.users.manager.service.persistence.TraccarUserPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the traccar user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mosin
 * @see TraccarUserPersistence
 * @see com.bmstu.users.manager.service.persistence.TraccarUserUtil
 * @generated
 */
@ProviderType
public class TraccarUserPersistenceImpl extends BasePersistenceImpl<TraccarUser>
	implements TraccarUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TraccarUserUtil} to access the traccar user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TraccarUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TraccarUserModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the traccar users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching traccar users
	 */
	@Override
	public List<TraccarUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TraccarUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<TraccarUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<TraccarUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<TraccarUser> list = null;

		if (retrieveFromCache) {
			list = (List<TraccarUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraccarUser traccarUser : list) {
					if (!Objects.equals(uuid, traccarUser.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first traccar user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByUuid_First(String uuid,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByUuid_First(uuid, orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the first traccar user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUuid_First(String uuid,
		OrderByComparator<TraccarUser> orderByComparator) {
		List<TraccarUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last traccar user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByUuid_Last(String uuid,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByUuid_Last(uuid, orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the last traccar user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUuid_Last(String uuid,
		OrderByComparator<TraccarUser> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraccarUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TraccarUser[] findByUuid_PrevAndNext(long traccarUserId,
		String uuid, OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = findByPrimaryKey(traccarUserId);

		Session session = null;

		try {
			session = openSession();

			TraccarUser[] array = new TraccarUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, traccarUser, uuid,
					orderByComparator, true);

			array[1] = traccarUser;

			array[2] = getByUuid_PrevAndNext(session, traccarUser, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraccarUser getByUuid_PrevAndNext(Session session,
		TraccarUser traccarUser, String uuid,
		OrderByComparator<TraccarUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACCARUSER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(traccarUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TraccarUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the traccar users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraccarUser traccarUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(traccarUser);
		}
	}

	/**
	 * Returns the number of traccar users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching traccar users
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "traccarUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "traccarUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(traccarUser.uuid IS NULL OR traccarUser.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TraccarUserModelImpl.UUID_COLUMN_BITMASK |
			TraccarUserModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the traccar user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTraccarUserException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByUUID_G(String uuid, long groupId)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByUUID_G(uuid, groupId);

		if (traccarUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTraccarUserException(msg.toString());
		}

		return traccarUser;
	}

	/**
	 * Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the traccar user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof TraccarUser) {
			TraccarUser traccarUser = (TraccarUser)result;

			if (!Objects.equals(uuid, traccarUser.getUuid()) ||
					(groupId != traccarUser.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<TraccarUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					TraccarUser traccarUser = list.get(0);

					result = traccarUser;

					cacheResult(traccarUser);

					if ((traccarUser.getUuid() == null) ||
							!traccarUser.getUuid().equals(uuid) ||
							(traccarUser.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, traccarUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TraccarUser)result;
		}
	}

	/**
	 * Removes the traccar user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the traccar user that was removed
	 */
	@Override
	public TraccarUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = findByUUID_G(uuid, groupId);

		return remove(traccarUser);
	}

	/**
	 * Returns the number of traccar users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching traccar users
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "traccarUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "traccarUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(traccarUser.uuid IS NULL OR traccarUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "traccarUser.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TraccarUserModelImpl.UUID_COLUMN_BITMASK |
			TraccarUserModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the traccar users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching traccar users
	 */
	@Override
	public List<TraccarUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TraccarUser> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<TraccarUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TraccarUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<TraccarUser> list = null;

		if (retrieveFromCache) {
			list = (List<TraccarUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraccarUser traccarUser : list) {
					if (!Objects.equals(uuid, traccarUser.getUuid()) ||
							(companyId != traccarUser.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TraccarUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the first traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator) {
		List<TraccarUser> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TraccarUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the last traccar user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraccarUser> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TraccarUser[] findByUuid_C_PrevAndNext(long traccarUserId,
		String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = findByPrimaryKey(traccarUserId);

		Session session = null;

		try {
			session = openSession();

			TraccarUser[] array = new TraccarUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, traccarUser, uuid,
					companyId, orderByComparator, true);

			array[1] = traccarUser;

			array[2] = getByUuid_C_PrevAndNext(session, traccarUser, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraccarUser getByUuid_C_PrevAndNext(Session session,
		TraccarUser traccarUser, String uuid, long companyId,
		OrderByComparator<TraccarUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TRACCARUSER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(traccarUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TraccarUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the traccar users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraccarUser traccarUser : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(traccarUser);
		}
	}

	/**
	 * Returns the number of traccar users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching traccar users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRACCARUSER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "traccarUser.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "traccarUser.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(traccarUser.uuid IS NULL OR traccarUser.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "traccarUser.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TraccarUserModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the traccar users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching traccar users
	 */
	@Override
	public List<TraccarUser> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TraccarUser> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<TraccarUser> findByGroupId(long groupId, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<TraccarUser> findByGroupId(long groupId, int start, int end,
		OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<TraccarUser> list = null;

		if (retrieveFromCache) {
			list = (List<TraccarUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraccarUser traccarUser : list) {
					if ((groupId != traccarUser.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACCARUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first traccar user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByGroupId_First(long groupId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByGroupId_First(groupId,
				orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the first traccar user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByGroupId_First(long groupId,
		OrderByComparator<TraccarUser> orderByComparator) {
		List<TraccarUser> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last traccar user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByGroupId_Last(long groupId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByGroupId_Last(groupId, orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the last traccar user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByGroupId_Last(long groupId,
		OrderByComparator<TraccarUser> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<TraccarUser> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TraccarUser[] findByGroupId_PrevAndNext(long traccarUserId,
		long groupId, OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = findByPrimaryKey(traccarUserId);

		Session session = null;

		try {
			session = openSession();

			TraccarUser[] array = new TraccarUserImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, traccarUser, groupId,
					orderByComparator, true);

			array[1] = traccarUser;

			array[2] = getByGroupId_PrevAndNext(session, traccarUser, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraccarUser getByGroupId_PrevAndNext(Session session,
		TraccarUser traccarUser, long groupId,
		OrderByComparator<TraccarUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRACCARUSER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(traccarUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TraccarUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the traccar users where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (TraccarUser traccarUser : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(traccarUser);
		}
	}

	/**
	 * Returns the number of traccar users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching traccar users
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACCARUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "traccarUser.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRACCARUSERID =
		new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraccarUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID =
		new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, TraccarUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTraccarUserId",
			new String[] { Long.class.getName() },
			TraccarUserModelImpl.TRACCARUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRACCARUSERID = new FinderPath(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraccarUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the traccar users where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @return the matching traccar users
	 */
	@Override
	public List<TraccarUser> findByTraccarUserId(long traccarUserId) {
		return findByTraccarUserId(traccarUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TraccarUser> findByTraccarUserId(long traccarUserId, int start,
		int end) {
		return findByTraccarUserId(traccarUserId, start, end, null);
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
	@Override
	public List<TraccarUser> findByTraccarUserId(long traccarUserId, int start,
		int end, OrderByComparator<TraccarUser> orderByComparator) {
		return findByTraccarUserId(traccarUserId, start, end,
			orderByComparator, true);
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
	@Override
	public List<TraccarUser> findByTraccarUserId(long traccarUserId, int start,
		int end, OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID;
			finderArgs = new Object[] { traccarUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRACCARUSERID;
			finderArgs = new Object[] {
					traccarUserId,
					
					start, end, orderByComparator
				};
		}

		List<TraccarUser> list = null;

		if (retrieveFromCache) {
			list = (List<TraccarUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraccarUser traccarUser : list) {
					if ((traccarUserId != traccarUser.getTraccarUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TRACCARUSER_WHERE);

			query.append(_FINDER_COLUMN_TRACCARUSERID_TRACCARUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TraccarUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(traccarUserId);

				if (!pagination) {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByTraccarUserId_First(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByTraccarUserId_First(traccarUserId,
				orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("traccarUserId=");
		msg.append(traccarUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the first traccar user in the ordered set where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByTraccarUserId_First(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator) {
		List<TraccarUser> list = findByTraccarUserId(traccarUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user
	 * @throws NoSuchTraccarUserException if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser findByTraccarUserId_Last(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByTraccarUserId_Last(traccarUserId,
				orderByComparator);

		if (traccarUser != null) {
			return traccarUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("traccarUserId=");
		msg.append(traccarUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTraccarUserException(msg.toString());
	}

	/**
	 * Returns the last traccar user in the ordered set where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching traccar user, or <code>null</code> if a matching traccar user could not be found
	 */
	@Override
	public TraccarUser fetchByTraccarUserId_Last(long traccarUserId,
		OrderByComparator<TraccarUser> orderByComparator) {
		int count = countByTraccarUserId(traccarUserId);

		if (count == 0) {
			return null;
		}

		List<TraccarUser> list = findByTraccarUserId(traccarUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the traccar users where traccarUserId = &#63; from the database.
	 *
	 * @param traccarUserId the traccar user ID
	 */
	@Override
	public void removeByTraccarUserId(long traccarUserId) {
		for (TraccarUser traccarUser : findByTraccarUserId(traccarUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(traccarUser);
		}
	}

	/**
	 * Returns the number of traccar users where traccarUserId = &#63;.
	 *
	 * @param traccarUserId the traccar user ID
	 * @return the number of matching traccar users
	 */
	@Override
	public int countByTraccarUserId(long traccarUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TRACCARUSERID;

		Object[] finderArgs = new Object[] { traccarUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRACCARUSER_WHERE);

			query.append(_FINDER_COLUMN_TRACCARUSERID_TRACCARUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(traccarUserId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRACCARUSERID_TRACCARUSERID_2 = "traccarUser.traccarUserId = ?";

	public TraccarUserPersistenceImpl() {
		setModelClass(TraccarUser.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("password", "password_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the traccar user in the entity cache if it is enabled.
	 *
	 * @param traccarUser the traccar user
	 */
	@Override
	public void cacheResult(TraccarUser traccarUser) {
		entityCache.putResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserImpl.class, traccarUser.getPrimaryKey(), traccarUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { traccarUser.getUuid(), traccarUser.getGroupId() },
			traccarUser);

		traccarUser.resetOriginalValues();
	}

	/**
	 * Caches the traccar users in the entity cache if it is enabled.
	 *
	 * @param traccarUsers the traccar users
	 */
	@Override
	public void cacheResult(List<TraccarUser> traccarUsers) {
		for (TraccarUser traccarUser : traccarUsers) {
			if (entityCache.getResult(
						TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
						TraccarUserImpl.class, traccarUser.getPrimaryKey()) == null) {
				cacheResult(traccarUser);
			}
			else {
				traccarUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all traccar users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraccarUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the traccar user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraccarUser traccarUser) {
		entityCache.removeResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserImpl.class, traccarUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TraccarUserModelImpl)traccarUser, true);
	}

	@Override
	public void clearCache(List<TraccarUser> traccarUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TraccarUser traccarUser : traccarUsers) {
			entityCache.removeResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
				TraccarUserImpl.class, traccarUser.getPrimaryKey());

			clearUniqueFindersCache((TraccarUserModelImpl)traccarUser, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TraccarUserModelImpl traccarUserModelImpl) {
		Object[] args = new Object[] {
				traccarUserModelImpl.getUuid(),
				traccarUserModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			traccarUserModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TraccarUserModelImpl traccarUserModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					traccarUserModelImpl.getUuid(),
					traccarUserModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((traccarUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					traccarUserModelImpl.getOriginalUuid(),
					traccarUserModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new traccar user with the primary key. Does not add the traccar user to the database.
	 *
	 * @param traccarUserId the primary key for the new traccar user
	 * @return the new traccar user
	 */
	@Override
	public TraccarUser create(long traccarUserId) {
		TraccarUser traccarUser = new TraccarUserImpl();

		traccarUser.setNew(true);
		traccarUser.setPrimaryKey(traccarUserId);

		String uuid = PortalUUIDUtil.generate();

		traccarUser.setUuid(uuid);

		traccarUser.setCompanyId(companyProvider.getCompanyId());

		return traccarUser;
	}

	/**
	 * Removes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traccarUserId the primary key of the traccar user
	 * @return the traccar user that was removed
	 * @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser remove(long traccarUserId)
		throws NoSuchTraccarUserException {
		return remove((Serializable)traccarUserId);
	}

	/**
	 * Removes the traccar user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the traccar user
	 * @return the traccar user that was removed
	 * @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser remove(Serializable primaryKey)
		throws NoSuchTraccarUserException {
		Session session = null;

		try {
			session = openSession();

			TraccarUser traccarUser = (TraccarUser)session.get(TraccarUserImpl.class,
					primaryKey);

			if (traccarUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraccarUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(traccarUser);
		}
		catch (NoSuchTraccarUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TraccarUser removeImpl(TraccarUser traccarUser) {
		traccarUser = toUnwrappedModel(traccarUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traccarUser)) {
				traccarUser = (TraccarUser)session.get(TraccarUserImpl.class,
						traccarUser.getPrimaryKeyObj());
			}

			if (traccarUser != null) {
				session.delete(traccarUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (traccarUser != null) {
			clearCache(traccarUser);
		}

		return traccarUser;
	}

	@Override
	public TraccarUser updateImpl(TraccarUser traccarUser) {
		traccarUser = toUnwrappedModel(traccarUser);

		boolean isNew = traccarUser.isNew();

		TraccarUserModelImpl traccarUserModelImpl = (TraccarUserModelImpl)traccarUser;

		if (Validator.isNull(traccarUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			traccarUser.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (traccarUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				traccarUser.setCreateDate(now);
			}
			else {
				traccarUser.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!traccarUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traccarUser.setModifiedDate(now);
			}
			else {
				traccarUser.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (traccarUser.isNew()) {
				session.save(traccarUser);

				traccarUser.setNew(false);
			}
			else {
				traccarUser = (TraccarUser)session.merge(traccarUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TraccarUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { traccarUserModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					traccarUserModelImpl.getUuid(),
					traccarUserModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { traccarUserModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { traccarUserModelImpl.getTraccarUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TRACCARUSERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((traccarUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						traccarUserModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { traccarUserModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((traccarUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						traccarUserModelImpl.getOriginalUuid(),
						traccarUserModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						traccarUserModelImpl.getUuid(),
						traccarUserModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((traccarUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						traccarUserModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { traccarUserModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((traccarUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						traccarUserModelImpl.getOriginalTraccarUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TRACCARUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID,
					args);

				args = new Object[] { traccarUserModelImpl.getTraccarUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TRACCARUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACCARUSERID,
					args);
			}
		}

		entityCache.putResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
			TraccarUserImpl.class, traccarUser.getPrimaryKey(), traccarUser,
			false);

		clearUniqueFindersCache(traccarUserModelImpl, false);
		cacheUniqueFindersCache(traccarUserModelImpl);

		traccarUser.resetOriginalValues();

		return traccarUser;
	}

	protected TraccarUser toUnwrappedModel(TraccarUser traccarUser) {
		if (traccarUser instanceof TraccarUserImpl) {
			return traccarUser;
		}

		TraccarUserImpl traccarUserImpl = new TraccarUserImpl();

		traccarUserImpl.setNew(traccarUser.isNew());
		traccarUserImpl.setPrimaryKey(traccarUser.getPrimaryKey());

		traccarUserImpl.setUuid(traccarUser.getUuid());
		traccarUserImpl.setTraccarUserId(traccarUser.getTraccarUserId());
		traccarUserImpl.setGroupId(traccarUser.getGroupId());
		traccarUserImpl.setCompanyId(traccarUser.getCompanyId());
		traccarUserImpl.setUserId(traccarUser.getUserId());
		traccarUserImpl.setUserName(traccarUser.getUserName());
		traccarUserImpl.setCreateDate(traccarUser.getCreateDate());
		traccarUserImpl.setModifiedDate(traccarUser.getModifiedDate());
		traccarUserImpl.setStatus(traccarUser.getStatus());
		traccarUserImpl.setStatusByUserId(traccarUser.getStatusByUserId());
		traccarUserImpl.setStatusByUserName(traccarUser.getStatusByUserName());
		traccarUserImpl.setStatusDate(traccarUser.getStatusDate());
		traccarUserImpl.setName(traccarUser.getName());
		traccarUserImpl.setPassword(traccarUser.getPassword());
		traccarUserImpl.setEmail(traccarUser.getEmail());

		return traccarUserImpl;
	}

	/**
	 * Returns the traccar user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the traccar user
	 * @return the traccar user
	 * @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTraccarUserException {
		TraccarUser traccarUser = fetchByPrimaryKey(primaryKey);

		if (traccarUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraccarUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return traccarUser;
	}

	/**
	 * Returns the traccar user with the primary key or throws a {@link NoSuchTraccarUserException} if it could not be found.
	 *
	 * @param traccarUserId the primary key of the traccar user
	 * @return the traccar user
	 * @throws NoSuchTraccarUserException if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser findByPrimaryKey(long traccarUserId)
		throws NoSuchTraccarUserException {
		return findByPrimaryKey((Serializable)traccarUserId);
	}

	/**
	 * Returns the traccar user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the traccar user
	 * @return the traccar user, or <code>null</code> if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
				TraccarUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TraccarUser traccarUser = (TraccarUser)serializable;

		if (traccarUser == null) {
			Session session = null;

			try {
				session = openSession();

				traccarUser = (TraccarUser)session.get(TraccarUserImpl.class,
						primaryKey);

				if (traccarUser != null) {
					cacheResult(traccarUser);
				}
				else {
					entityCache.putResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
						TraccarUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
					TraccarUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return traccarUser;
	}

	/**
	 * Returns the traccar user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traccarUserId the primary key of the traccar user
	 * @return the traccar user, or <code>null</code> if a traccar user with the primary key could not be found
	 */
	@Override
	public TraccarUser fetchByPrimaryKey(long traccarUserId) {
		return fetchByPrimaryKey((Serializable)traccarUserId);
	}

	@Override
	public Map<Serializable, TraccarUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TraccarUser> map = new HashMap<Serializable, TraccarUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TraccarUser traccarUser = fetchByPrimaryKey(primaryKey);

			if (traccarUser != null) {
				map.put(primaryKey, traccarUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
					TraccarUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TraccarUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TRACCARUSER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TraccarUser traccarUser : (List<TraccarUser>)q.list()) {
				map.put(traccarUser.getPrimaryKeyObj(), traccarUser);

				cacheResult(traccarUser);

				uncachedPrimaryKeys.remove(traccarUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TraccarUserModelImpl.ENTITY_CACHE_ENABLED,
					TraccarUserImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the traccar users.
	 *
	 * @return the traccar users
	 */
	@Override
	public List<TraccarUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TraccarUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TraccarUser> findAll(int start, int end,
		OrderByComparator<TraccarUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TraccarUser> findAll(int start, int end,
		OrderByComparator<TraccarUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TraccarUser> list = null;

		if (retrieveFromCache) {
			list = (List<TraccarUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TRACCARUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRACCARUSER;

				if (pagination) {
					sql = sql.concat(TraccarUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TraccarUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the traccar users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraccarUser traccarUser : findAll()) {
			remove(traccarUser);
		}
	}

	/**
	 * Returns the number of traccar users.
	 *
	 * @return the number of traccar users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TRACCARUSER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraccarUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the traccar user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TraccarUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TRACCARUSER = "SELECT traccarUser FROM TraccarUser traccarUser";
	private static final String _SQL_SELECT_TRACCARUSER_WHERE_PKS_IN = "SELECT traccarUser FROM TraccarUser traccarUser WHERE traccarUserId IN (";
	private static final String _SQL_SELECT_TRACCARUSER_WHERE = "SELECT traccarUser FROM TraccarUser traccarUser WHERE ";
	private static final String _SQL_COUNT_TRACCARUSER = "SELECT COUNT(traccarUser) FROM TraccarUser traccarUser";
	private static final String _SQL_COUNT_TRACCARUSER_WHERE = "SELECT COUNT(traccarUser) FROM TraccarUser traccarUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "traccarUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TraccarUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TraccarUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TraccarUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "password"
			});
}