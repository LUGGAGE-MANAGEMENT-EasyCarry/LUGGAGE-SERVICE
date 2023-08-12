CREATE TYPE states as enum (
    'CHECK_IN',
    'IN_AIRPORT','IN_WAY'
    ,'RECEIVED','PENDING'
);

ALTER TABLE luggage
ADD COLUMN state states