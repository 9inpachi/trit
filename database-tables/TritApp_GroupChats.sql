--------------------------------------------------------
--  File created - Saturday-June-30-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TRITAPP_GROUPCHATS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."TRITAPP_GROUPCHATS" 
   (	"GROUPID" NUMBER(*,0), 
	"SENDERID" NUMBER(*,0), 
	"MESSAGE_TIME" TIMESTAMP (6), 
	"MESSAGE" VARCHAR2(2000 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.TRITAPP_GROUPCHATS
SET DEFINE OFF;
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('24-JUN-18 06.25.40.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Username1 is also a part :)');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (3,5,to_timestamp('24-JUN-18 06.33.38.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Wow. username5 sent a message!');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (3,3,to_timestamp('24-JUN-18 06.33.55.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'Well. username3 is here as well xD');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (2,1,to_timestamp('24-JUN-18 06.51.13.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'how are you
');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (4,6,to_timestamp('24-JUN-18 10.42.41.000000000 PM','DD-MON-RR HH.MI.SS.FF AM'),'username6 here with a message!');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (1,3,to_timestamp('24-JUN-18 02.09.10.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'This is my first message.');
Insert into SYSTEM.TRITAPP_GROUPCHATS (GROUPID,SENDERID,MESSAGE_TIME,MESSAGE) values (2,4,to_timestamp('24-JUN-18 02.11.21.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'I will type a message here.');
--------------------------------------------------------
--  Ref Constraints for Table TRITAPP_GROUPCHATS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."TRITAPP_GROUPCHATS" ADD FOREIGN KEY ("GROUPID")
	  REFERENCES "SYSTEM"."TRITAPP_GROUPS" ("GROUPID") ENABLE;
