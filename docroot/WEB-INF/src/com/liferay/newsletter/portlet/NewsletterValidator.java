/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterValidator {

	public static boolean validateCampaignContent(CampaignContent campaignContent, List errors) {
		boolean valid = true;

		if (Validator.isNull(campaignContent.getTitle())) {
			errors.add("campaignContenttitle-required");
			valid = false;
		}

		if (Validator.isNull(campaignContent.getContent())) {
			errors.add("campaignContentcontent-required");
			valid = false;
		}

		return valid;
	}

	public static boolean validateCampaign(
		Campaign campaign, String contacts, List errors) {

		boolean valid = true;

		if (Validator.isNull(campaign.getEmailSubject())) {
			errors.add("campaignemailsubject-required");

			valid = false;
		}

		if (Validator.isNull(campaign.getSenderEmail())) {
			errors.add("campaignsenderemail-required");

			valid = false;
		}

		if (!Validator.isEmailAddress(campaign.getSenderEmail())) {
			errors.add("campaignsenderemail-format-error");

			valid = false;
		}

		if (Validator.isNull(campaign.getSenderName())) {
			errors.add("campaignsendername-required");
			valid = false;
		}

		// Validar emails dos contatos
		if (Validator.isNull(contacts)) {
			errors.add("campaigncontacts-required");
			valid = false;
		}

		return valid;
	}

}