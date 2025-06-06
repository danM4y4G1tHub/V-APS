-- Búsqueda por diagnóstico y fecha
SELECT p.resource->>'name' AS paciente,
       c.resource->'code'->'coding'->0->>'display' AS diagnostico
FROM patients p
JOIN conditions c 
  ON c.resource->'subject'->>'reference' = 'Patient/' || p.id
WHERE c.resource @> '{"code":{"coding":[{"display":"Diabetes"}]}}'
  AND c.resource->>'recordedDate' > '2023-01-01';