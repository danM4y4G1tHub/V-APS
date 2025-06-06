WITH riesgo AS (
  SELECT p.id,
         COUNT(c.*) * 10 + 
         MAX(o.resource->'valueQuantity'->>'value')::INT AS score
  FROM patients p
  LEFT JOIN conditions c 
    ON c.resource->'subject'->>'reference' = 'Patient/' || p.id
  LEFT JOIN observations o 
    ON o.resource->'subject'->>'reference' = 'Patient/' || p.id
  GROUP BY p.id
)
SELECT p.resource->>'name' AS paciente, score
FROM riesgo
JOIN patients p USING(id)
ORDER BY score DESC;