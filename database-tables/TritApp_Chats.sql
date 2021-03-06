--------------------------------------------------------
--  File created - Saturday-June-30-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TRITAPP_CHATS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."TRITAPP_CHATS" 
   (	"SENDERID" NUMBER(*,0), 
	"RECEIVERID" NUMBER(*,0), 
	"MESSAGE_TIME" TIMESTAMP (6), 
	"MESSAGE" VARCHAR2(2000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.TRITAPP_CHATS
SET DEFINE OFF;
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'This is a message from username1');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('17-JUN-18 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'This is a message from username2');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 04.27.02.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Hello you are nice person.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.02.02.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What a joke');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 03.02.44.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'How are you bru?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 03.02.55.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I guess I am doing fine.
What about you?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (3,1,to_timestamp('17-JUN-18 03.21.24.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'How are you man?

');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('17-JUN-18 03.22.43.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I am a joke alright.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('17-JUN-18 03.22.51.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I get ya there');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,3,to_timestamp('17-JUN-18 03.23.52.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What are you man?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,3,to_timestamp('17-JUN-18 03.24.01.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'You are doing what?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,3,to_timestamp('17-JUN-18 03.24.40.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What? Time is so fast!');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.25.22.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What are you dude?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('17-JUN-18 03.25.33.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I am nothing');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('24-JUN-18 06.22.30.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'My new message.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('17-JUN-18 03.25.50.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What null message?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.25.56.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'Yes');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.28.23.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I will be typing a very long message here that will let me check the wrapping of the element and easily tell me everything.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('24-JUN-18 06.22.35.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'What?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (5,3,to_timestamp('24-JUN-18 06.31.31.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'A brand new message ka?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (3,5,to_timestamp('24-JUN-18 06.32.43.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Ye. From your side. :)');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.30.57.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'Type your message here...');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.31.01.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'asdasd');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.31.41.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'asdasd');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('17-JUN-18 03.31.47.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'What a message');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 04.27.39.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Whasdasd');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 05.05.00.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'sadas');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (3,1,to_timestamp('17-JUN-18 05.25.09.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Type your message here...');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 05.25.22.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'How are you yar?');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 05.27.02.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'asdsa');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('17-JUN-18 05.27.55.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'This is a test message from username1.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (3,1,to_timestamp('17-JUN-18 05.28.07.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'This is a message from username3.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('19-JUN-18 08.51.57.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'What are you doing boi?
');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,2,to_timestamp('19-JUN-18 08.52.06.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Nothing really.');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('23-JUN-18 07.07.31.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'My new message');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (4,2,to_timestamp('24-JUN-18 02.10.45.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'My new message');
Insert into SYSTEM.TRITAPP_CHATS (SENDERID,RECEIVERID,MESSAGE_TIME,MESSAGE) values (6,3,to_timestamp('24-JUN-18 10.42.06.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Hello! How are you doing?');
