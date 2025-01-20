INSERT INTO Waste_Categories (id, name, description) VALUES
(1, 'Organic', 'Biodegradable waste from plants or animals'),
(2, 'Plastic', 'Synthetic or semi-synthetic materials'),
(3, 'Paper', 'Materials made from wood pulp or other fibrous substances');


INSERT INTO Disposal_Guidelines (id, name, description, category_id) 
VALUES 
(1, 'Paper Recycling', 'Separate clean paper items and place in blue recycling bins', 1),
(2, 'Battery Disposal', 'Place used batteries in designated battery recycling containers', 2),
(3, 'Food Waste', 'Collect food scraps in compost bins for organic processing', 3),
(4, 'Glass Recycling', 'Clean and separate glass by color before recycling', 1),
(5, 'Chemical Waste', 'Store in original containers and schedule hazardous pickup', 2),
(6, 'Garden Waste', 'Place yard trimmings in green waste bins for composting', 3);
