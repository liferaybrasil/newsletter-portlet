create index IX_BE2C6700 on Newsletter_Campaign (emailSubject);
create index IX_4F61540E on Newsletter_Campaign (groupId);
create index IX_53DAD9E6 on Newsletter_Campaign (sendDate);
create index IX_6EEBB6F0 on Newsletter_Campaign (senderName);
create index IX_EA76EB6C on Newsletter_Campaign (title);
create index IX_33389218 on Newsletter_Campaign (uuid_);

create index IX_A956CF1C on Newsletter_Campaign_Contact (campaignId);
create index IX_FF4A4D8E on Newsletter_Campaign_Contact (contactId);

create index IX_8DBB6DD4 on Newsletter_Contact (uuid_);

create index IX_25E51609 on Newsletter_NewsletterLog (uuid_);

create index IX_60077670 on Newsletter_SendCampaign (uuid_);