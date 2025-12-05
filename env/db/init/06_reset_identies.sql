SELECT setval (
        pg_get_serial_sequence ('profils', 'pro_id'), coalesce(MAX(pro_id), 1)
    )
from PROFILS;

SELECT setval (
        pg_get_serial_sequence ('utilisateurs', 'uti_id'), coalesce(MAX(uti_id), 1)
    )
from UTILISATEURS;