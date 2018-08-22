package co.grandcircus.coffeeshop.dao;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Coffee;


	@Repository
	public class CoffeeDao {
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public List<Coffee> findAll(){
			String sql = "SELECT * FROM coffeetable";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Coffee.class));
		}

	}
	

