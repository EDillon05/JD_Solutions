CREATE TABLE IF NOT EXISTS administrative (
    id INT PRIMARY KEY, -- mismo ID que base_document
    position VARCHAR(255) NOT NULL,
    academic_unit VARCHAR(255) NOT NULL,
    institution VARCHAR(255) NOT NULL,
    level VARCHAR(255) NOT NULL,
    modality VARCHAR(255) NOT NULL,
    CONSTRAINT fk_administrative_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS recognition (
    id INT PRIMARY KEY, -- mismo ID que base_document
    institution_given VARCHAR(255) NOT NULL,
    reason VARCHAR(255) NOT NULL,
    level VARCHAR(255) NOT NULL,
    type_of_recognition VARCHAR(255) NOT NULL,
    CONSTRAINT fk_recognition_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS research (
    id INT PRIMARY KEY, -- mismo ID que base_document
    publication_type VARCHAR(255) NOT NULL,
    publication_title VARCHAR(255) NOT NULL,
    magazine_name VARCHAR(255),
    publication_date TIMESTAMP,
    doi VARCHAR(255),
    isbn VARCHAR(255),
    event_name VARCHAR(255),
    CONSTRAINT fk_research_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS  project (
    id INT PRIMARY KEY, -- mismo ID que base_document
    role VARCHAR(255) NOT NULL,
    institution_name VARCHAR(255) NOT NULL,
    budget VARCHAR(255),
    project_link VARCHAR(255),
    publication_date TIMESTAMP,
    disciplinary_area VARCHAR(255),
    CONSTRAINT fk_project_base_document FOREIGN KEY (id) REFERENCES base_document_entity(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS project_research (
    id INT PRIMARY KEY, -- mismo ID que base_document
    project_id INT NOT NULL,
    research_id INT NOT NULL,
    CONSTRAINT fk_project_research_project FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE,
    CONSTRAINT fk_project_research_research FOREIGN KEY (research_id) REFERENCES research(id) ON DELETE CASCADE
);