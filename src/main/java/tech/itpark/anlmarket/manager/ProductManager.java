package tech.itpark.anlmarket.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.anlmarket.mapper.ProductRowMapper;
import tech.itpark.anlmarket.domain.Product;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductManager {
    private final NamedParameterJdbcTemplate template;

    private final ProductRowMapper rowMapper = new ProductRowMapper();

    public List<Product> getAll() {
        return template.query(
                "SELECT id,name,category,price,imageURL,store_id,store_name FROM products ORDER BY id LIMIT 50",
                rowMapper
        );
    }


    public Product getById(long id) {
        return template.queryForObject(
                "SELECT id, name,category,price,imageURL,store_id,store_name FROM products WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );

    }

    public Product search(String name) {
        return template.queryForObject(
                "SELECT id, name,category,price,imageURL,store_id,store_name FROM products WHERE name = :name",
                Map.of("name", name),
                rowMapper
        );

    }



    public Product save(Product item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO products(name,category,price,imageURL,store_id,store_name) VALUES (:name, :category,:price,:imageURL, :store_id, :store_name )",
                    new MapSqlParameterSource(Map.of(
                            "name", item.getName(),
                            "category", item.getCategory(),
                            "price", item.getPrice(),
                            "imageURL", item.getImageURL(),
                            "store_id", item.getStore_id(),
                            "store_name", item.getStore_name()

                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update(
                "UPDATE products SET name = :name, category = :category, price = :price,imageURL = :imageURL, store_id = :store_id, store_name = :store_name WHERE id = :id",
                (Map.of(
                        "id", item.getId(),
                        "name", item.getName(),
                        "category", item.getCategory(),
                        "price", item.getPrice(),
                        "imageURL", item.getImageURL(),
                        "store_id", item.getStore_id(),
                        "store_name", item.getStore_name()

                ))
        );

        return getById(item.getId());
    }


    public Product removeById(long id) {
        Product item = getById(id);


        template.update(
                "DELETE FROM products WHERE id = :id",
                (Map.of(
                        "id", item.getId()

                ))
        );

        return item;
    }

}