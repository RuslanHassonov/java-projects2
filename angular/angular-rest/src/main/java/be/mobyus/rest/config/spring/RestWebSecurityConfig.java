package be.mobyus.rest.config.spring;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.security.config.http.SessionCreationPolicy.IF_REQUIRED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import be.mobyus.service.security.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class RestWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Autowired
	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter;

	private CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF8", true, true);

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests()
				/**
				 * For the static UI files being served by this webapp which do not require authentication
				 */
				//Note: the paths in 'ui' do not correspond to actual resources. These are 'virtual' paths which are
				// wildcard mapped to the index.html by a view controller to be able to bootstrap Angular
				.antMatchers("/*").permitAll().antMatchers("/ui/**").permitAll()

				/**
				 * For the public services offered by the API which do not require authentication
				 */.antMatchers("/api/public/**").permitAll()

				/**
				 * For the secured services offered by the API authentication is required
				 */.antMatchers("/api/authenticated/**").fullyAuthenticated();

		if (environment.acceptsProfiles("development")) {
			/**
			 * In production mode the UI is expected to be served from the same security domain as the service (rest) layer (note: this does not mean they need to be
			 * served from the same SERVER. Security domain is term of how the browser sees it. Two different servers can operate in the same security domain if using a
			 * proxy for example). However, in development mode this is not the case as two different servers are used and without anything extra to make a single
			 * security domain. Therefore we enable CORS in NON production mode.
			 */
			http.authorizeRequests().antMatchers(OPTIONS, "/api/authenticated/**").permitAll();
			http.cors();
		}

		/**
		 * All other requests are denied by default
		 */
		http.authorizeRequests().anyRequest().denyAll().and().headers().frameOptions().deny().and().sessionManagement().sessionCreationPolicy(IF_REQUIRED)

				/**
				 * This is on purpose. CSRF is taken care of automatically by the security tokens.
				 * Please refer to the security architectural document for more information
				 */.and().csrf().disable();

		http.addFilterBefore(characterEncodingFilter, SecurityContextPersistenceFilter.class);
		http.addFilter(usernamePasswordAuthenticationFilter);
		http.logout().logoutSuccessHandler((request, response, authentication) -> {
		}).invalidateHttpSession(true);
		http.antMatcher("/**");
	}

	@Bean
	public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
		usernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager);
		usernamePasswordAuthenticationFilter.setPostOnly(true);
		usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/api/open/login");
		usernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
			response.setStatus(SC_OK);
		});
		return usernamePasswordAuthenticationFilter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());

		return authenticationProvider;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
