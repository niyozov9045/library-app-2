package uz.pdp.libraryapp2.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp2.model.Category;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {


    private final JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategoriesFromDb() {
        String sql = "select * from categories";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                Category.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build()

        );
    }

    public void addNewCategory(Category category) {
        String sql = "insert into categories (name, description)\n" +
                "values ('" + category.getName() + "' , '" + category.getDescription() + "');";
        int update = jdbcTemplate.update(sql);

    }

    public void editCategory(Category category) throws IllegalAccessException {
        try {
            String sql =
                    "UPDATE categories SET name = '" + category.getName() + "',description  = '" + category.getDescription() +
                            "'" +
                            " " +
                            "WHERE id =" + category.getId() + ";";
            int update = jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new IllegalAccessException("Something went wrong...");
        }
    }

    public void deleteCategoryById(Integer id) throws IllegalAccessException {

        try {
            String sql = "delete FROM categories where id = " + id + ";";
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Something went wrong...");
        }
    }

    public Category getCategoryById(Integer id) {
        String sql = "select * from categories where id = " + id;
        Category category = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Category.class));
        return category;
    }

}
