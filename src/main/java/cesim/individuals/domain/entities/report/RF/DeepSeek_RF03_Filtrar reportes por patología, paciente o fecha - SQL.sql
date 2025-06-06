-- Filtrar pacientes diabéticos en 2023
SELECT p.resource->>'name' AS paciente,
       c.resource->'code'->'coding'->0->>'display' AS diagnostico
FROM conditions c
JOIN patients p 
  ON p.id = split_part(c.resource->'subject'->>'reference', '/', 2)::UUID
WHERE c.resource @> '{"code":{"coding":[{"code":"44054006"}]}}'
  AND c.resource->>'recordedDate' BETWEEN '2023-01-01' AND '2023-12-31';