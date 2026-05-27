# Cursos de ejemplo para la Pregunta 3
# Nota: si la tabla ya tiene datos, Spring puede fallar por 'codigo' unique.
# En ese caso, borra la DB o ajusta códigos.

INSERT INTO cursos (codigo, nombre, creditos, modalidad, vacantes) VALUES
('INF101', 'Introducción a la Programación', 4, 'Presencial', 10),
('MAT201', 'Matemática Discreta', 3, 'Virtual', 0),
('BD301', 'Base de Datos', 4, 'Semipresencial', 5)
ON CONFLICT (codigo) DO NOTHING;
