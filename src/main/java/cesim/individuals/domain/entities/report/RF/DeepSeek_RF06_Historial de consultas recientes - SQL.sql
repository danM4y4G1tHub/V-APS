SELECT e.resource->'period'->>'start' AS fecha,
       e.resource->'type'->'coding'->0->>'display' AS tipo,
       p.resource->>'name' AS medico
FROM encounters e
JOIN practitioners p 
  ON p.id = split_part(e.resource->'participant'->0->'individual'->>'reference', '/', 2)
WHERE e.resource->'participant' @> '[{"individual":{"reference":"Practitioner/XXXX"}}]'
  AND e.resource->'period'->>'start' BETWEEN '2024-01-01' AND '2024-05-30';