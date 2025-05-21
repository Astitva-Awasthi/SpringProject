-- 1. USERS table
CREATE TABLE users (
    id        NUMBER(19) PRIMARY KEY,
    email     VARCHAR2(255 CHAR) NOT NULL,
    password  VARCHAR2(255 CHAR) NOT NULL,
    username  VARCHAR2(255 CHAR) NOT NULL
);

-- 2. PROJECTS table
CREATE TABLE projects (
    id           NUMBER(19) PRIMARY KEY,
    name         VARCHAR2(255 CHAR) NOT NULL,
    project_key  VARCHAR2(50 CHAR) UNIQUE NOT NULL,
    description  VARCHAR2(1000 CHAR),
    owner_id     NUMBER(19),
    CONSTRAINT fk_project_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);

-- 3. ISSUES table
CREATE TABLE issues (
    id           NUMBER(19) PRIMARY KEY,
    title        VARCHAR2(255 CHAR) NOT NULL,
    description  VARCHAR2(2000 CHAR),
    status       VARCHAR2(50 CHAR) DEFAULT 'TO_DO',
    priority     VARCHAR2(50 CHAR) DEFAULT 'MEDIUM',
    project_id   NUMBER(19) NOT NULL,
    assignee_id  NUMBER(19),
    reporter_id  NUMBER(19),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_issue_project   FOREIGN KEY (project_id) REFERENCES projects(id),
    CONSTRAINT fk_issue_assignee  FOREIGN KEY (assignee_id) REFERENCES users(id),
    CONSTRAINT fk_issue_reporter  FOREIGN KEY (reporter_id) REFERENCES users(id)
);

-- 4. COMMENTS table
CREATE TABLE comments (
    id         NUMBER(19) PRIMARY KEY,
    message    VARCHAR2(2000 CHAR) NOT NULL,
    author_id  NUMBER(19) NOT NULL,
    issue_id   NUMBER(19) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_comment_author FOREIGN KEY (author_id) REFERENCES users(id),
    CONSTRAINT fk_comment_issue  FOREIGN KEY (issue_id) REFERENCES issues(id)
);

-- 5. SPRINTS table
CREATE TABLE sprints (
    id          NUMBER(19) PRIMARY KEY,
    name        VARCHAR2(255 CHAR) NOT NULL,
    start_date  DATE,
    end_date    DATE,
    project_id  NUMBER(19) NOT NULL,

    CONSTRAINT fk_sprint_project FOREIGN KEY (project_id) REFERENCES projects(id)
);

-- 6. SPRINT_ISSUES (many-to-many relationship)
CREATE TABLE sprint_issues (
    sprint_id NUMBER(19) NOT NULL,
    issue_id  NUMBER(19) NOT NULL,

    CONSTRAINT pk_sprint_issues PRIMARY KEY (sprint_id, issue_id),
    CONSTRAINT fk_sprint_issues_sprint FOREIGN KEY (sprint_id) REFERENCES sprints(id),
    CONSTRAINT fk_sprint_issues_issue  FOREIGN KEY (issue_id) REFERENCES issues(id)
);
