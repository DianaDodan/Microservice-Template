CREATE TABLE IF NOT EXISTS transaction_data (
    id UUID PRIMARY KEY NOT NULL,
    date_time TIMESTAMP NOT NULL,
    stock_item_id UUID NOT NULL REFERENCES stock_data (id),
    quantity_before INT NOT NULL,
    quantity_after INT NOT NULL
);