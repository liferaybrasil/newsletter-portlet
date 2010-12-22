package com.liferay.newsletter.service.messaging;

import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.ClpSerializer;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.SendCampaignLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(SERVLET_CONTEXT_NAME)) {
            CampaignLocalServiceUtil.clearService();

            ContactLocalServiceUtil.clearService();

            SendCampaignLocalServiceUtil.clearService();

            NewsletterLogLocalServiceUtil.clearService();
        }
    }
}
