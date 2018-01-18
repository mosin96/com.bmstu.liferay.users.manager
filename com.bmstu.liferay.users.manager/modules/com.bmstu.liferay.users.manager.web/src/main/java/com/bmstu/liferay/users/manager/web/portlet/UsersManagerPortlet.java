package com.bmstu.liferay.users.manager.web.portlet;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.bmstu.liferay.users.manager.web.constants.UsersManagerPortletKeys;
import com.bmstu.users.manager.model.TraccarUser;
import com.bmstu.users.manager.service.TraccarUserLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * 
 * Users manager portlet.
 * 
 * @author Mosin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Traccar",
		"com.liferay.portlet.instanceable=false", "com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=Users Manager", "javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UsersManagerPortletKeys.UsersManager, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html" }, service = Portlet.class)
public class UsersManagerPortlet extends MVCPortlet {

	private TraccarUserLocalService traccarUserLocalService;

	/**
	 * 
	 * Adds traccar user to data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void addTraccarUser(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TraccarUser.class.getName(), request);

		String traccarUserName = ParamUtil.getString(request, "name");
		String traccarUserPassword = ParamUtil.getString(request, "password");
		String traccarUserEmail = ParamUtil.getString(request, "email");

		try {
			traccarUserLocalService.addTraccarUser(serviceContext.getUserId(), traccarUserName, traccarUserPassword,
					traccarUserEmail, serviceContext);
			SessionMessages.add(request, "Traccar User Added");
		} catch (Exception e) {
			System.out.println(e);
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "edit_user.jsp");
		}
	}

	/**
	 * 
	 * Deletes traccar user from data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void deleteTraccarUser(ActionRequest request, ActionResponse response) throws PortalException {
		long traccarUserId = ParamUtil.getLong(request, "traccarUserId");
		traccarUserLocalService.deleteTraccarUser(traccarUserId);
	}
	
	/**
	 * 
	 * Binds traccar user service.
	 * 
	 */
	@Reference(unbind = "-")
	protected void bindTraccarUserService(TraccarUserLocalService traccarUserLocalService) {
		this.traccarUserLocalService = traccarUserLocalService;
	}
}