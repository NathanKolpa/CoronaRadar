create table infected_stat
(
    infected_stat_id varchar(256) primary key,
    date_added date,
    foreign key (province_id) references provinces(province_id),
    counter int,
    foreign key (date_origin_id) references date_origins(date_origin_id)
)