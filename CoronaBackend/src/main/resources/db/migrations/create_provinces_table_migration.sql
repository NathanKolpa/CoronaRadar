create table provinces
(
    province_id varchar(256) primary key,
    foreign key (country_id) REFERENCES country(country_id),
    name varchar(256)
)