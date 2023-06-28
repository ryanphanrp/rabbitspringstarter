create table if not exists notification (
    notification_id int unique primary key not null auto_increment,
    user_id int not null,
    title text not null,
    message text not null
)