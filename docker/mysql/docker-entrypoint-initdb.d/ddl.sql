CREATE TABLE payments (
    id bigint NOT NULL AUTO_INCREMENT,
    payment_type enum('PLANED_PAYMENT', 'NON_PLANED_PAYMENT'),
    item_code varchar(128) NOT NULL,
    payment_date date NOT NULL,
    payment_amount bigint NOT NULL,
    note varchar(400),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
