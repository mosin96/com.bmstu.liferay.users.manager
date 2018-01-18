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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TraccarUser service. Represents a row in the &quot;UM_TraccarUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mosin
 * @see TraccarUserModel
 * @see com.bmstu.users.manager.model.impl.TraccarUserImpl
 * @see com.bmstu.users.manager.model.impl.TraccarUserModelImpl
 * @generated
 */
@ImplementationClassName("com.bmstu.users.manager.model.impl.TraccarUserImpl")
@ProviderType
public interface TraccarUser extends TraccarUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.bmstu.users.manager.model.impl.TraccarUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TraccarUser, Long> TRACCAR_USER_ID_ACCESSOR = new Accessor<TraccarUser, Long>() {
			@Override
			public Long get(TraccarUser traccarUser) {
				return traccarUser.getTraccarUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TraccarUser> getTypeClass() {
				return TraccarUser.class;
			}
		};
}