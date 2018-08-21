package co.grandcircus.coffeeshop;

	public class Coffee {
		
		private String name;
		private String category;
		private String description;
		private String firstname;
		private String lastname;
		private String password;
		
		public Coffee() {}
		
		public Coffee(String firstname, String lastname, String password) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.password = password;
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
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "Coffee [firstname=\" + firstname + \", lastname=\" + lastname + \", category=" + category + "]";
		}

		public String getCategory() {
			return category;
		}
		
	}

