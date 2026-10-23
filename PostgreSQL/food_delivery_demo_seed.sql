BEGIN;

-- Restaurants
INSERT INTO tbl_restaurant (
    code, name, category, description, rating, address,
    phone_number, open_time, close_time, created_by, created_at
)
SELECT seed.code, seed.name, seed.category, seed.description,
       seed.rating, seed.address, seed.phone_number,
       seed.open_time, seed.close_time, 'SYSTEM', NOW()
FROM (VALUES
    ('DEMO-KHMER-01', 'Mekong Kitchen', 'Khmer',
     'Comforting Cambodian favorites made fresh.', 4.8,
     '12 Riverside Road, Phnom Penh', '+85512345001', TIME '09:00', TIME '21:00'),
    ('DEMO-BURGER-01', 'The Green Bun', 'Burgers',
     'Juicy burgers, crisp sides, and house-made sauces.', 4.6,
     '24 Street 240, Phnom Penh', '+85512345002', TIME '10:00', TIME '22:00'),
    ('DEMO-ITALIAN-01', 'Little Olive', 'Italian',
     'Hand-tossed pizza and simple Italian comfort food.', 4.7,
     '8 Street 51, Phnom Penh', '+85512345003', TIME '11:00', TIME '22:00')
) AS seed(code, name, category, description, rating, address, phone_number, open_time, close_time)
WHERE NOT EXISTS (
    SELECT 1 FROM tbl_restaurant existing WHERE existing.code = seed.code
);

-- Menu items. Restaurant IDs are looked up by restaurant code.
INSERT INTO tbl_menu_item (
    code, name, description, price, availability, restaurant_id, created_by, created_at
)
SELECT seed.code, seed.name, seed.description, seed.price, 1,
       restaurant.id, 'SYSTEM', NOW()
FROM (VALUES
    ('DEMO-KHMER-01', 'Fish Amok', 'Traditional coconut curry steamed with fragrant herbs.', 7.50, 'KHMER-AMOK-01'),
    ('DEMO-KHMER-01', 'Lok Lak', 'Stir-fried beef with pepper-lime dipping sauce.', 8.00, 'KHMER-LOKLAK-01'),
    ('DEMO-KHMER-01', 'Green Mango Salad', 'Green mango, fresh herbs, and toasted peanuts.', 5.00, 'KHMER-SALAD-01'),
    ('DEMO-BURGER-01', 'Classic House Burger', 'Beef patty, lettuce, tomato, and house sauce.', 8.50, 'BURGER-CLASSIC-01'),
    ('DEMO-BURGER-01', 'Crispy Chicken Bun', 'Crispy chicken, slaw, and a tangy dressing.', 7.50, 'BURGER-CHICKEN-01'),
    ('DEMO-BURGER-01', 'Golden Fries', 'Seasoned fries served hot and crisp.', 3.00, 'BURGER-FRIES-01'),
    ('DEMO-ITALIAN-01', 'Margherita Pizza', 'Tomato, mozzarella, and fresh basil.', 9.00, 'ITALIAN-MARGHERITA-01'),
    ('DEMO-ITALIAN-01', 'Creamy Mushroom Pasta', 'Pasta with mushrooms and a creamy sauce.', 8.50, 'ITALIAN-PASTA-01'),
    ('DEMO-ITALIAN-01', 'Garlic Bread', 'Toasted bread with garlic and herbs.', 3.50, 'ITALIAN-BREAD-01')
) AS seed(restaurant_code, name, description, price, code)
JOIN tbl_restaurant restaurant ON restaurant.code = seed.restaurant_code
WHERE NOT EXISTS (
    SELECT 1 FROM tbl_menu_item existing WHERE existing.code = seed.code
);

-- Demo customer required by POST /v1/orders.
INSERT INTO tbl_user (
    username, first_name, last_name, gender, date_of_birth, email,
    phone_number, address, user_type, status, created_by, created_at
)
VALUES (
    'demo.customer', 'Demo', 'Customer', 'OTHER', DATE '1995-01-01',
    'demo.customer@example.test', '+85512345999',
    '12 Demo Street, Phnom Penh', 'REGULAR', 'ACTIVE', 'SYSTEM', NOW()
)
ON CONFLICT (username) DO NOTHING;

-- Available courier required by POST /v1/orders.
INSERT INTO tbl_delivery_partner (
    first_name, last_name, username, phone_number, email, address,
    vehicle_type, available, created_by, created_at
)
VALUES (
    'Demo', 'Courier', 'demo.courier', '+85512345888',
    'demo.courier@example.test', 'Phnom Penh',
    'MOTORCYCLE', TRUE, 'SYSTEM', NOW()
)
ON CONFLICT (username) DO NOTHING;

COMMIT;

-- Find the demo customer ID for checkout.
SELECT id, username, phone_number
FROM tbl_user
WHERE username = 'demo.customer';

-- Confirm restaurant and menu data.
SELECT r.name AS restaurant, r.category, m.name AS menu_item, m.price
FROM tbl_restaurant r
LEFT JOIN tbl_menu_item m ON m.restaurant_id = r.id
WHERE r.code LIKE 'DEMO-%'
ORDER BY r.name, m.name;
