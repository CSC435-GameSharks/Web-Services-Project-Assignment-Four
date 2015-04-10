# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table items (
  id                        varchar(255) not null,
  name                      varchar(255),
  icon                      varchar(255),
  display_color             varchar(255),
  tooltip_params            varchar(255),
  constraint pk_items primary key (id))
;

create sequence items_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists items;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists items_seq;

