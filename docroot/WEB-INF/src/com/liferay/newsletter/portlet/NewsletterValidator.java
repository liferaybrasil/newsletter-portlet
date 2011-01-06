package com.liferay.newsletter.portlet;

import java.util.List;

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.SendCampaignLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class NewsletterValidator {

	public static boolean validateCampaign(Campaign campaign, List errors) {
		boolean valid = true;

		if (Validator.isNull(campaign.getTitle())) {
			errors.add("campaigntitle-required");
			valid = false;
		}

		if (Validator.isNull(campaign.getContent())) {
			errors.add("campaigncontent-required");
			valid = false;
		}

		return valid;
	}
	
	public static boolean validateSendCampaign(
		SendCampaign sendCampaign, String contacts, List errors) {

		boolean valid = true;

		if (Validator.isNull(sendCampaign.getEmailSubject())) {
			errors.add("sendcampaignemailsubject-required");
			valid = false;
		}

		if (Validator.isNull(sendCampaign.getSenderEmail())) {
			errors.add("sendcampaignsenderemail-required");
			valid = false;
		}

		if (!Validator.isEmailAddress(sendCampaign.getSenderEmail())) {
			errors.add("sendcampaignsenderemail-format-error");
			valid = false;
		}

		if (Validator.isNull(sendCampaign.getSenderName())) {
			errors.add("sendcampaignsendername-required");
			valid = false;
		}

		// Validar emails dos contatos
		if (Validator.isNull(contacts)) {
			errors.add("sendcampaigncontacts-required");
			valid = false;
		}

		return valid;
	}
}