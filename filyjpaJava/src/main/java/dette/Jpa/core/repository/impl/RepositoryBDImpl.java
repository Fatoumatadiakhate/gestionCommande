package dette.Jpa.core.repository.impl;

import java.sql.*;

import dette.Jpa.core.database.impl.DatabaseImpl;
import dette.Jpa.core.repository.Repository;

public abstract class RepositoryBDImpl<T> extends DatabaseImpl implements Repository<T> {
    // Creer les methodes insert et selectAll par reflexion
    protected String tableName;
    public abstract T convertToObject(ResultSet rs) throws SQLException;
}
