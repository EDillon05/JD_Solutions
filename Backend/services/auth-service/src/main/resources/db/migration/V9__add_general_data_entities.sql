-- Tabla de perfil
CREATE TABLE IF NOT EXISTS profile (
    id SERIAL PRIMARY KEY,
    profile_picture_url VARCHAR(255),
    bio VARCHAR(255),
    user_id INT NOT NULL,
    CONSTRAINT fk_profile_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabla base de documentos
CREATE TABLE IF NOT EXISTS base_document_entity (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    description TEXT,
    country VARCHAR(255) NOT NULL,
    started_at TIMESTAMP NOT NULL,
    finished_at TIMESTAMP NOT NULL,
    comment TEXT,
    url VARCHAR(255),
    status VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    owner_id INT NOT NULL,
    CONSTRAINT fk_base_document_profile FOREIGN KEY (owner_id) REFERENCES profile(id) ON DELETE CASCADE
);

-- Subtabla: carrera
CREATE TABLE IF NOT EXISTS career (
    id INT PRIMARY KEY, -- mismo ID que base_document
    level VARCHAR(255) NOT NULL,
    institution VARCHAR(255) NOT NULL,
    certification_name VARCHAR(255) NOT NULL,
    license_id VARCHAR(255),
    modality VARCHAR(255) NOT NULL,
    graduation_date TIMESTAMP,
    CONSTRAINT fk_career_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

-- Subtabla: experiencia
CREATE TABLE IF NOT EXISTS experience (
    id INT PRIMARY KEY, -- mismo ID que base_document
    company_name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    area VARCHAR(255) NOT NULL,
    contract_type VARCHAR(255) NOT NULL,
    CONSTRAINT fk_experience_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

-- Subtabla: docencia
CREATE TABLE IF NOT EXISTS teaching (
    id INT PRIMARY KEY, -- mismo ID que base_document
    assessment_name VARCHAR(255) NOT NULL,
    program_name VARCHAR(255) NOT NULL,
    level VARCHAR(255) NOT NULL,
    institution VARCHAR(255) NOT NULL,
    modality VARCHAR(255) NOT NULL,
    weekly_hours VARCHAR(255) NOT NULL,
    CONSTRAINT fk_teaching_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

-- Secuencias (opcional si usas SERIAL, pero puedes mantenerlas si las necesitas)
CREATE SEQUENCE IF NOT EXISTS profile_seq;
CREATE SEQUENCE IF NOT EXISTS base_document_seq;
