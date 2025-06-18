INSERT INTO hotel (
    hotel_name, hotel_address, hotel_capacity, hotel_city, hotel_country, hotel_phone,
    hotel_email, hotel_website, price_per_night, hotel_type,
    hotel_description, has_wifi, has_parking, has_pool, has_gym,
    has_restaurant, has_spa, has_bar, has_laundry, has_room_service,
    has_conference_room, hotel_photos
) VALUES
('Hotel Sol', 'Av. del Sol 123', 120, 'Mendoza', 'Argentina', 2615551234, 'sol@hotel.com', 'https://hotelsol.com', 80.5, 'resort', 'Un hotel con vista a la montaña y desayuno incluido.', true, true, true, true, true, false, true, true, true, false, '/uploads/sol.png'),
('Hotel Playa', 'Calle Arena 456', 150, 'Mar del Plata', 'Argentina', 2231234567, 'playa@hotel.com', 'https://hotelplaya.com', 120.0, 'hotel', 'Ideal para vacaciones familiares junto al mar.', true, true, true, false, true, true, true, false, true, true, '/uploads/hotelplaya.png'),
('City Inn', 'Av. Corrientes 789', 30, 'Buenos Aires', 'Argentina', 1156789876,  'city@hotel.com', 'https://cityinn.com', 55.0, 'motel', 'Ubicado en el corazón de la ciudad, ideal para viajes de trabajo.', true, false, false, true, true, false, false, true, false, true, '/uploads/cityinn.png'),
('Hotel 1', 'Calle 1 Nº 100', 100, 'Ciudad 1', 'País A', '+1000000001', 'hotel1@mail.com', 'https://hotel1.com', 101, 'Hotel', 'Descripción del hotel 1.', true, true, false, false, true, false, true, true, false, true, '/images/hotel1.jpg'),
('Hotel 2', 'Calle 2 Nº 101', 101, 'Ciudad 2', 'País B', '+1000000002', 'hotel2@mail.com', 'https://hotel2.com', 102, 'Hostal', 'Descripción del hotel 2.', true, false, false, true, false, false, false, true, false, false, '/images/hotel2.jpg'),
('Hotel 3', 'Calle 3 Nº 102', 102, 'Ciudad 3', 'País C', '+1000000003', 'hotel3@mail.com', 'https://hotel3.com', 103, 'Resort', 'Descripción del hotel 3.', false, true, true, false, true, true, false, false, true, true, '/images/hotel3.jpg'),
('Hotel 4', 'Calle 4 Nº 103', 103, 'Ciudad 4', 'País A', '+1000000004', 'hotel4@mail.com', 'https://hotel4.com', 104, 'Hotel', 'Descripción del hotel 4.', true, false, true, true, true, false, false, true, true, false, '/images/hotel4.jpg'),
('Hotel 5', 'Calle 5 Nº 104', 104, 'Ciudad 5', 'País B', '+1000000005', 'hotel5@mail.com', 'https://hotel5.com', 105, 'Hostal', 'Descripción del hotel 5.', false, true, false, false, false, false, false, false, false, false, '/images/hotel5.jpg'),
('Hotel 6', 'Calle 6 Nº 105', 105, 'Ciudad 6', 'País C', '+1000000006', 'hotel6@mail.com', 'https://hotel6.com', 106, 'Resort', 'Descripción del hotel 6.', true, true, true, true, true, true, true, true, true, true, '/images/hotel6.jpg'),
('Hotel 7', 'Calle 7 Nº 106', 106, 'Ciudad 7', 'País A', '+1000000007', 'hotel7@mail.com', 'https://hotel7.com', 107, 'Hotel', 'Descripción del hotel 7.', true, false, true, false, true, false, false, false, true, true, '/images/hotel7.jpg'),
('Hotel 8', 'Calle 8 Nº 107', 107, 'Ciudad 8', 'País B', '+1000000008', 'hotel8@mail.com', 'https://hotel8.com', 108, 'Hostal', 'Descripción del hotel 8.', false, true, false, false, true, false, false, true, false, false, '/images/hotel8.jpg'),
('Hotel 9', 'Calle 9 Nº 108', 108, 'Ciudad 9', 'País C', '+1000000009', 'hotel9@mail.com', 'https://hotel9.com', 109, 'Resort', 'Descripción del hotel 9.', true, true, false, true, false, true, true, false, true, true, '/images/hotel9.jpg'),
('Hotel 10', 'Calle 10 Nº 109', 109, 'Ciudad 10', 'País A', '+1000000010', 'hotel10@mail.com', 'https://hotel10.com', 110, 'Hotel', 'Descripción del hotel 10.', true, true, true, false, true, true, false, false, true, false, '/images/hotel10.jpg'),
('Hotel 51', 'Calle 51 Nº 150', 150, 'Ciudad 51', 'País C', '+1000000051', 'hotel51@mail.com', 'https://hotel51.com', 151, 'Resort', 'Descripción del hotel 51.', true, false, false, false, true, false, true, false, true, false, '/images/hotel51.jpg'),
('Hotel 52', 'Calle 52 Nº 151', 151, 'Ciudad 52', 'País A', '+1000000052', 'hotel52@mail.com', 'https://hotel52.com', 152, 'Hotel', 'Descripción del hotel 52.', true, true, true, false, false, true, true, true, false, true, '/images/hotel52.jpg'),
('Hotel 53', 'Calle 53 Nº 152', 152, 'Ciudad 53', 'País B', '+1000000053', 'hotel53@mail.com', 'https://hotel53.com', 153, 'Hostal', 'Descripción del hotel 53.', false, true, false, true, false, false, false, false, true, false, '/images/hotel53.jpg'),
('Hotel 54', 'Calle 54 Nº 153', 153, 'Ciudad 54', 'País C', '+1000000054', 'hotel54@mail.com', 'https://hotel54.com', 154, 'Resort', 'Descripción del hotel 54.', true, true, true, true, true, true, true, true, true, true, '/images/hotel54.jpg'),
('Hotel 55', 'Calle 55 Nº 154', 154, 'Ciudad 55', 'País A', '+1000000055', 'hotel55@mail.com', 'https://hotel55.com', 155, 'Hotel', 'Descripción del hotel 55.', false, false, false, false, false, false, false, false, false, false, '/images/hotel55.jpg'),
('Hotel 56', 'Calle 56 Nº 155', 155, 'Ciudad 56', 'País B', '+1000000056', 'hotel56@mail.com', 'https://hotel56.com', 156, 'Hostal', 'Descripción del hotel 56.', true, true, true, true, false, false, true, false, true, false, '/images/hotel56.jpg'),
('Hotel 57', 'Calle 57 Nº 156', 156, 'Ciudad 57', 'País C', '+1000000057', 'hotel57@mail.com', 'https://hotel57.com', 157, 'Resort', 'Descripción del hotel 57.', true, false, false, false, true, true, false, true, false, true, '/images/hotel57.jpg'),
('Hotel 58', 'Calle 58 Nº 157', 157, 'Ciudad 58', 'País A', '+1000000058', 'hotel58@mail.com', 'https://hotel58.com', 158, 'Hotel', 'Descripción del hotel 58.', false, true, false, true, true, false, true, false, false, false, '/images/hotel58.jpg'),
('Hotel 59', 'Calle 59 Nº 158', 158, 'Ciudad 59', 'País B', '+1000000059', 'hotel59@mail.com', 'https://hotel59.com', 159, 'Hostal', 'Descripción del hotel 59.', true, true, true, false, false, true, false, true, true, true, '/images/hotel59.jpg'),
('Hotel 60', 'Calle 60 Nº 159', 159, 'Ciudad 60', 'País C', '+1000000060', 'hotel60@mail.com', 'https://hotel60.com', 160, 'Resort', 'Descripción del hotel 60.', true, true, false, true, true, true, true, true, true, false, '/images/hotel60.jpg');

INSERT INTO Users (
    name, last_name, email, password, user_role
) VALUES
('admin', 'admin', 'admin@gmail.com', 'admin', 'admin');
