

INSERT IGNORE INTO cart (user_id) VALUES ('user1'), ('user2');

INSERT INTO cart_items (cart_user_id, product_id, product_name, quantity, price)
VALUES
  ('user1', 'P1001', 'Smartphone Pro', 1, 32000.00),
  ('user1', 'P1002', 'Wireless Headset', 2, 2499.00),
  ('user2', 'P2001', 'Gaming Mouse', 1, 1499.50);
