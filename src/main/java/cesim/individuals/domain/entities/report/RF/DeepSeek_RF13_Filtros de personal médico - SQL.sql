SELECT COUNT(*) AS medicos, 
       o.resource->>'name' AS policlinico
FROM practitioners p
JOIN organizations o 
  ON o.id = split_part(p.resource->'organization'->>'reference', '/', 2)
GROUP BY policlinico;