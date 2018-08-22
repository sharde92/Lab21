package co.grandcircus.coffeeshop;

	public class User {
		
			
		private String firstname;
		private String lastname;
		private String password;
		private String email;
		private String phone_number;
		private String age;
		
		public User() {}
		
		public User(String firstname, String lastname, String password, String email, String phone_number, String age) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
			this.email = email;
			this.phone_number = phone_number;
			this.age = age;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
		
		
	
	}

