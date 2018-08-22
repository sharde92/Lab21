package co.grandcircus.coffeeshop.dao;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.User;


	@Repository
	public class CoffeeShopDao {
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public List<User> findAll(){
			String sql = "SELECT * FROM user_table";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
		

	}
		public User findById(Long id) {
			String sql = "SELECT * FROM user_table WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
		}
		
		public void create(User user) {
			System.out.println("Create: " + user);
		String sql = "INSERT INTO user_table (firstname, lastname, password,email,phonenumber, age) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getFirstname(), user.getLastname(), user.getPassword(), user.getEmail(), user.getPhone_number(), user.getAge());
	}
	}
	
