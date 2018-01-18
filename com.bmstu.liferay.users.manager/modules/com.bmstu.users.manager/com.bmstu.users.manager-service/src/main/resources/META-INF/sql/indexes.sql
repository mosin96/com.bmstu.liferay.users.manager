create index IX_90C9BD4C on UM_TraccarUser (groupId);
create index IX_2934F0BE on UM_TraccarUser (traccarUserId, groupId);
create index IX_1D00CF92 on UM_TraccarUser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B53C1294 on UM_TraccarUser (uuid_[$COLUMN_LENGTH:75$], groupId);