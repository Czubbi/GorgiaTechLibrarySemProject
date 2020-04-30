package GTL_API.Handlers.Security;

import GTL_API.Handlers.Encrpytion.EncryptionHandler;
import GTL_API.Models.Entities.CredentialsEntity;
import GTL_API.Repositories.CredentialsRepository.ICredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private ICredentialsRepository credentialsRepository;

    public CustomUserDetailsService(ICredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<CredentialsEntity> found = credentialsRepository.findByLoginIs(login);
        if (!found.isPresent()) {
            throw new UsernameNotFoundException(String.format("User with login %s was not found."));
        } else {
            User toReturn = new User(
                    found.get().getLogin(),
                    found.get().getPassword(),
                    getAuthority(found.get().getRole())
            );
            return toReturn;
        }
    }

    private Set<SimpleGrantedAuthority> getAuthority(String authority) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(authority));
        return authorities;
    }
}
