package com.stockmanagement.app.repo;

import com.stockmanagement.app.domain.StockItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StockRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StockItem> getAll() {
        return jdbcTemplate.query("SELECT * from stock_data",
                BeanPropertyRowMapper.newInstance(StockItem.class));
    }

    public StockItem getItemByID(UUID id) {
        return jdbcTemplate.queryForObject("SELECT * FROM stock_data WHERE id = ?",
                new Object[]{id.toString()}, BeanPropertyRowMapper.newInstance(StockItem.class));
    }

    public void createStockItem(StockItem stockItem) {
        jdbcTemplate.update("INSERT INTO stock_data VALUES (?, ?, ?)",
                stockItem.getId(), stockItem.getName(), stockItem.getQuantity());
    }
}
