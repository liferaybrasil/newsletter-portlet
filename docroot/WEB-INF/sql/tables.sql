create table Newsletter_Campaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
	sentDate DATE null,
	emailSubject VARCHAR(75) null,
	senderEmail VARCHAR(75) null,
	senderName VARCHAR(75) null,
	content STRING null,
	sent BOOLEAN,
	campaignContentId LONG
);

create table Newsletter_CampaignContent (
	uuid_ VARCHAR(75) null,
	campaignContentId LONG not null primary key,
	title VARCHAR(75) null,
	content STRING null,
	createDate DATE null,
	articleId LONG
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

create table Newsletter_NewsletterCampaign (
	uuid_ VARCHAR(75) null,
	campaignId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	contentId LONG,
	emailSubject VARCHAR(75) null,
	senderEmail VARCHAR(75) null,
	senderName VARCHAR(75) null,
	sent BOOLEAN,
	sendDate DATE null
);

create table Newsletter_NewsletterContact (
	contactId LONG not null primary key,
	email VARCHAR(75) null,
	name VARCHAR(75) null
);

create table Newsletter_NewsletterContent (
	uuid_ VARCHAR(75) null,
	contentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	articleId LONG
);

create table Newsletter_NewsletterLog (
	logId LONG not null primary key,
	campaignId LONG,
	contactId LONG,
	sent BOOLEAN
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