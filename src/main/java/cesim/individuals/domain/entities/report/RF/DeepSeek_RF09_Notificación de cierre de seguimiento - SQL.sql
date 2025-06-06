-- Job diario que verifica CarePlans finalizados
SELECT p.resource->>'name' AS paciente,
       cp.resource->'period'->>'end' AS fin_seguimiento
FROM care_plans cp
JOIN patients p 
  ON p.id = split_part(cp.resource->'subject'->>'reference', '/', 2)
WHERE cp.resource->>'status' = 'active'
  AND cp.resource->'period'->>'end' = CURRENT_DATE;