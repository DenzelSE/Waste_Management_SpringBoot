INSERT INTO Waste_Categories (id, name, description) VALUES
(1, 'Organic', 'Biodegradable waste from plants or animals'),
(2, 'Plastic', 'Synthetic or semi-synthetic materials'),
(3, 'Paper', 'Materials made from wood pulp or other fibrous substances');


INSERT INTO Disposal_Guidelines (name, description, category_id) 
VALUES 
-- Paper waste tips
('Paper Recycling', 'Separate clean paper items and place in blue recycling bins', 3),
('Cardboard Processing', 'Break down boxes completely. Remove all tape and staples. Keep dry and clean. Bundle large quantities for easier handling.', 3),

-- Plastic waste
('Plastic Container Preparation', 'Clean all containers thoroughly. Remove labels where possible. Sort by plastic type numbers (1-7) if required by local facilities.', 2),
('Bottle and Cap Handling', 'Empty and rinse bottles completely. Remove caps and process separately as they are often made from different types of plastic.', 2),

-- Organic waste
('Food Waste', 'Collect food scraps in compost bins for organic processing', 1),
('Garden Waste', 'Place yard trimmings in green waste bins for composting', 1);

INSERT INTO Reycling_Tips (tip, category_id) 
VALUES 
-- Organic waste tips
('Collect kitchen scraps in a countertop compost bin for easy sorting', 1),
('Mix green materials (vegetable scraps) with brown materials (dry leaves) for better composting', 1),
-- Plastic waste tips
('Check the recycling number on plastic containers before disposal', 2),
-- Paper waste tips
('Keep paper dry and clean to maintain recyclability', 3),
('Remove plastic windows from envelopes before recycling', 3);
