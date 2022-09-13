package uz.pdp.libraryapp2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp2.model.Records;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecordsDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Records> getALLRecordsFromDb() {
        String sql = "select * from records";
        return jdbcTemplate.query(sql, (rs, row) ->
                Records.builder()
                        .is_returned(rs.getBoolean(2))
                        .dateTime(rs.getTimestamp(3).toLocalDateTime())
                        .user_id(rs.getInt(4))
                        .build()
        );
    }

    public void addNewRecords(Records records) {
        String sql = "insert into records(user_id) VALUES ('"+records.getUser_id()+"')";
                int update = jdbcTemplate.update(sql);
    }

    public void editRecords(Records records) {

        String sql = "update records SET is_returned= '"+records.is_returned()+"','"+records.getDateTime()+"','"+records.getUser_id()+"' where id="+records.getId()+";";
         int update = jdbcTemplate.update(sql);
    }

    public void deleteRecords(Integer id) {

        String sql = "delete from records where id = '"+id+"';";

        int update = jdbcTemplate.update(sql);
    }

    public Records getRecordsById(Integer id) {

        String sql = "select * from records where id="+id;
        Records records = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Records.class));
        return records;

    }

}
