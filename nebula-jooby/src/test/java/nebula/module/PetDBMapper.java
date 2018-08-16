package nebula.module;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PetDBMapper implements RowMapper<Pet> {
	@Override
	public Pet map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		return new Pet(rs.getLong("id"), rs.getString("name"), rs.getString("desciption"));
	}
}