package org.jee.ecommerce.user;

import java.util.Optional;

import org.jee.ecommerce.user.model.Customer;
import org.jee.ecommerce.user.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements UserDetailsService {

	private final UserRepository repository;

	public UserAuthenticationService(UserRepository repository) {
		this.repository = repository;
	}

	public Optional<Customer> getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Fetch User from the DB
		Optional<Customer> userRes = repository.findByEmail(email);
		// No user found
		if(userRes.isEmpty())
			throw new UsernameNotFoundException("Could not findUser with email = " + email);
		// Return a User Details object using the fetched User information
		Customer user = userRes.get();
		return new org.springframework.security.core.userdetails.User(
				email,
				user.getPassword(),
				user.getAuthorities()); // Sets the role of the found user

	}


}
