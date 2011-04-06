create table Newsletter_Campaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
	title VARCHAR(75) null,
	content STRING null
);

create table Newsletter_Campaign_Contact (
	contactId LONG not null,
	campaignId LONG not null,
	primary key (contactId, campaignId)
);

create table Newsletter_Contact (
	uuid_ VARCHAR(75) null,
	contactId LONG not null primary key,
	email VARCHAR(75) null,
	name VARCHAR(75) null
);

create table Newsletter_NewsletterLog (
	uuid_ VARCHAR(75) null,
	newsletterLogId LONG not null primary key,
	sendCampaignId LONG,
	contactId LONG
);

create table Newsletter_SendCampaign (
	uuid_ VARCHAR(75) null,
	sendCampaignId LONG not null primary key,
	sendDate DATE null,
	emailSubject VARCHAR(75) null,
	senderName VARCHAR(75) null,
	senderEmail VARCHAR(75) null,
	sent BOOLEAN,
	campaignId LONG
);