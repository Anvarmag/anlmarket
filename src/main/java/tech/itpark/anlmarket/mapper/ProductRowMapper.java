package tech.itpark.anlmarket.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.anlmarket.domain.Product;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getInt("price"),
                rs.getString("imageURL"),
                rs.getLong("store_id"),
                rs.getString("store_name")


        );
    }


}
