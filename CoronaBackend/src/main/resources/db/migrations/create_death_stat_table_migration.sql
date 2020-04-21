create table death_stat
(
    death_stat_id int primary key auto_increment,
    date_added date,
    foreign key (province_id) references provinces(province_id),
    counter int,
    foreign key (date_origin_id) references date_origins(date_origin_id)
)