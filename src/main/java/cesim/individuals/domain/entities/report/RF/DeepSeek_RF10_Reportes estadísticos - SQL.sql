-- Pacientes hipertensos por grupo etario
SELECT date_part('year', age(resource->>'birthDate'))/10 AS decada,
       COUNT(*) FILTER (WHERE resource @> '{"code":{"coding":[{"code":"38341003"}]}}')
FROM patients p
JOIN conditions c 
  ON c.resource->'subject'->>'reference' = 'Patient/' || p.id
GROUP BY decada;