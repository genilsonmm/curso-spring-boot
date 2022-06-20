package com.gm2.cryptoapp.repository;

import com.gm2.cryptoapp.dto.CoinTransationDTO;
import com.gm2.cryptoapp.entity.Coin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class CoinRepository {

    private static String INSERT = "insert into coin (name, price, quantity, datetime) values (?,?,?,?)";

    private static String SELECT_ALL = "select name, sum(quantity) as quantity from coin group by name";

    private static String SELECT_BY_NAME = "select * from coin where name = ?";

    private static String DELETE = "delete from coin where id = ?";

    private static String UPDATE = "update coin set name = ?, price = ?, quantity = ? where id = ?";

    private JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public Coin insert (Coin coin){
        Object[] attr = new Object[] {
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDateTime()
        };
        jdbcTemplate.update(INSERT, attr);
        return coin;
    }

    public Coin update(Coin coin){
        Object[] attr = new Object[] {
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getId()
        };
        jdbcTemplate.update(UPDATE, attr);
        return coin;
    }

    public List<CoinTransationDTO> getAll(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<CoinTransationDTO>() {
            @Override
            public CoinTransationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

                CoinTransationDTO coin = new CoinTransationDTO();
                coin.setName(rs.getString("name"));
                coin.setQuantity(rs.getBigDecimal("quantity"));

                return coin;
            }
        });
    }

    public List<Coin> getByName(String name){
        Object[] attr = new Object[] { name };
        return jdbcTemplate.query(SELECT_BY_NAME, new RowMapper<Coin>() {
            @Override
            public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {

                Coin coin = new Coin();
                coin.setId(rs.getInt("id"));
                coin.setName(rs.getString("name"));
                coin.setPrice(rs.getBigDecimal("price"));
                coin.setQuantity(rs.getBigDecimal("quantity"));
                coin.setDateTime(rs.getTimestamp("datetime"));

                return coin;
            }
        }, attr);
    }

    public int remove(int id){
        return jdbcTemplate.update(DELETE, id);
    }
}
