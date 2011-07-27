create index IX_FD898F58 on Newsletter_Campaign (campaignContentId);
create index IX_BE2C6700 on Newsletter_Campaign (emailSubject);
create index IX_4F61540E on Newsletter_Campaign (groupId);
create index IX_53DAD9E6 on Newsletter_Campaign (sendDate);
create index IX_A4C8EAF2 on Newsletter_Campaign (sendDate, sent);
create index IX_6EEBB6F0 on Newsletter_Campaign (senderName);
create index IX_A23E8DF6 on Newsletter_Campaign (sentDate);
create index IX_8CF95302 on Newsletter_Campaign (sentDate, sent);
create index IX_EA76EB6C on Newsletter_Campaign (title);
create index IX_33389218 on Newsletter_Campaign (uuid_);

create index IX_8FD90A1F on Newsletter_CampaignContent (title);
create index IX_D89AB0CB on Newsletter_CampaignContent (uuid_);

create index IX_A956CF1C on Newsletter_Campaign_Contact (campaignId);
create index IX_FF4A4D8E on Newsletter_Campaign_Contact (contactId);

create index IX_3142AF6C on Newsletter_Contact (email);
create index IX_BDBA079F on Newsletter_Contact (name);
create index IX_8DBB6DD4 on Newsletter_Contact (uuid_);

create index IX_58F76CCF on Newsletter_NewsletterCampaign (contentId);
create index IX_43C2B0CF on Newsletter_NewsletterCampaign (sentDate);
create index IX_66842F1B on Newsletter_NewsletterCampaign (sentDate, sent);
create index IX_A93605DF on Newsletter_NewsletterCampaign (uuid_);
create unique index IX_313E99AB on Newsletter_NewsletterCampaign (uuid_, groupId);

create index IX_C17426C5 on Newsletter_NewsletterContact (email);
create index IX_3E3FC126 on Newsletter_NewsletterContact (name);

create index IX_59C58248 on Newsletter_NewsletterContent (title);
create index IX_A28728F4 on Newsletter_NewsletterContent (uuid_);
create unique index IX_378B1E36 on Newsletter_NewsletterContent (uuid_, groupId);

create index IX_4DCAD2CA on Newsletter_NewsletterLog (campaignId);
create index IX_DA01CD41 on Newsletter_NewsletterLog (campaignId, contactId);
create index IX_E3901C20 on Newsletter_NewsletterLog (contactId);
create index IX_AE191BF2 on Newsletter_NewsletterLog (sendCampaignId);
create index IX_25E51609 on Newsletter_NewsletterLog (uuid_);

create index IX_99E79AC3 on Newsletter_SendCampaign (campaignId);
create index IX_B419768E on Newsletter_SendCampaign (sendDate);
create index IX_61B9699A on Newsletter_SendCampaign (sendDate, sent);
create index IX_60077670 on Newsletter_SendCampaign (uuid_);