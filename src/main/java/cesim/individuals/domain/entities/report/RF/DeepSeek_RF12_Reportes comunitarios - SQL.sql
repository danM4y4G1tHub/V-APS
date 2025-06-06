SELECT l.resource->>'name' AS comunidad,
       COUNT(*) FILTER (WHERE c.resource @> '{"code":{"coding":[{"code":"J45.90"}]}}') AS asma_cases
FROM conditions c
JOIN patients p 
  ON p.id = split_part(c.resource->'subject'->>'reference', '/', 2)
JOIN locations l 
  ON l.id = split_part(p.resource->'address'->>'reference', '/', 2)
GROUP BY comunidad;