INSERT INTO Waste_Categories (id, name, description) VALUES
(1, 'Organic', 'Biodegradable waste from plants or animals'),
(2, 'Plastic', 'Synthetic or semi-synthetic materials'),
(3, 'Paper', 'Materials made from wood pulp or other fibrous substances');


INSERT INTO Disposal_Guidelines (name, description, category_id) 
VALUES 
-- Paper
('Paper Recycling', 'Separate clean paper items and place in blue recycling bins', 3),
('Cardboard Processing', 'Break down boxes completely. Remove all tape and staples. Keep dry and clean. Bundle large quantities for easier handling.', 3),

-- Plastic 
('Plastic Container Preparation', 'Clean all containers thoroughly. Remove labels where possible. Sort by plastic type numbers (1-7) if required by local facilities.', 2),
('Bottle and Cap Handling', 'Empty and rinse bottles completely. Remove caps and process separately as they are often made from different types of plastic.', 2),

-- Organic
('Food Waste', 'Collect food scraps in compost bins for organic processing', 1),
('Garden Waste', 'Place yard trimmings in green waste bins for composting', 1);

INSERT INTO Recycling_Tips (tip, category_id) 
VALUES 
-- Organic
('Collect kitchen scraps in a countertop compost bin for easy sorting', 1),
('Mix green materials (vegetable scraps) with brown materials (dry leaves) for better composting', 1),
-- Plastic 
('Check the recycling number on plastic containers before disposal', 2),
-- Paper 
('Keep paper dry and clean to maintain recyclability', 3),
('Remove plastic windows from envelopes before recycling', 3);

INSERT INTO Waste_Items (name, description, category_id) 
VALUES 
-- Organic 
('Fruit Peels', 'Discarded outer layers of fruits including banana peels, orange rinds, and apple skins', 1),
('Tea Bags', 'Used tea bags and loose tea leaves', 1),
-- Plastic 
('Water Bottles', 'Empty plastic bottles used for water and beverages (Type 1 PET)', 2),
('Shopping Bags', 'Plastic bags from retail stores and groceries (Type 2 HDPE)', 2),
-- Paper 
('Newspapers', 'Daily or weekly printed news publications', 3),
('Receipts', 'Paper transaction records from stores and services', 3);