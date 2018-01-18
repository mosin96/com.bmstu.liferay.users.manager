create table UM_TraccarUser (
	uuid_ VARCHAR(75) null,
	traccarUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	password_ VARCHAR(75) null,
	email VARCHAR(75) null
);