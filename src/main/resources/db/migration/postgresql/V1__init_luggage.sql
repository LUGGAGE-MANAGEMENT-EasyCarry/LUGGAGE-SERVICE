CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE  luggage(
                         luggage_id uuid NOT NULL DEFAULT uuid_generate_v4(),
                         weight float  NOT NULL,
                         flight_id uuid NOT NULL,
                         customer_id uuid NOT NULL,
                         stateType varchar(255) NOT NULL,
                         PRIMARY KEY (luggage_id)
);
