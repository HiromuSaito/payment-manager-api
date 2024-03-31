CREATE TABLE items (
    item_code varchar(128) NOT NULL,
    manufacturer_code date NOT NULL,
    item_name varchar(200) NOT NULL,
    is_eop BOOLEAN NOT NULL,
    PRIMARY KEY (item_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE payments (
    id bigint NOT NULL AUTO_INCREMENT,
    payment_type enum('PLANED_PAYMENT', 'NON_PLANED_PAYMENT'),
    item_code varchar(128) NOT NULL,
    payment_date date NOT NULL,
    payment_amount bigint NOT NULL,
    note varchar(400),
    PRIMARY KEY (id),
    FOREIGN KEY (item_code)
        REFERENCES items(item_code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;