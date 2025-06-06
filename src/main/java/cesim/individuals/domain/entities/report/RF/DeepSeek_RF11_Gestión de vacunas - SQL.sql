-- Vacunas pendientes por paciente
SELECT p.resource->>'name' AS paciente,
       i.resource->'vaccineCode'->>'display' AS vacuna,
       (i.resource->'protocolApplied'->0->>'series')::INT - 
       (i.resource->'protocolApplied'->0->>'doseNumberPositiveInt')::INT AS dosis_faltantes
FROM immunizations i
JOIN patients p 
  ON p.id = split_part(i.resource->'patient'->>'reference', '/', 2);