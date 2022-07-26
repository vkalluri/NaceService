DROP TABLE IF EXISTS TBL_NACE;

CREATE TABLE TBL_NACE (
  order_id INT PRIMARY KEY,
  level INT NOT NULL,
  code VARCHAR(250) NOT NULL,
  parent VARCHAR(250) DEFAULT NULL,
  description VARCHAR(250) NOT  NULL,
  includes VARCHAR(250) DEFAULT NULL,
  extra_includes VARCHAR(250) DEFAULT NULL,
  rulings VARCHAR(250) DEFAULT NULL,
  excludes VARCHAR(250) DEFAULT NULL,
  reference_details VARCHAR(250) DEFAULT NULL
);