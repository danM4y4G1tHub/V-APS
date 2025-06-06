SELECT a.resource->>'start' AS cita,
       p.resource->>'name' AS paciente
FROM appointments a
LEFT JOIN encounters e 
  ON e.resource->'appointment'->>'reference' = 'Appointment/' || a.id
JOIN patients p 
  ON p.id = split_part(a.resource->'participant'->0->'actor'->>'reference', '/', 2)
WHERE e.id IS NULL
  AND a.resource->>'status' = 'booked'
  AND a.resource->>'start' < CURRENT_DATE;