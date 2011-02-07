/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.newsletter.portlet;

import java.util.List;

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Bruno Pinheiro
 */
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