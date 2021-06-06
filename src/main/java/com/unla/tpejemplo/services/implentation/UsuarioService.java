package com.unla.tpejemplo.services.implentation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.tpejemplo.entities.Usuario;
import com.unla.tpejemplo.entities.UsuarioRol;
import com.unla.tpejemplo.repositories.IUsuarioRepository;



@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsernameAndFetchUsuarioRolEagerly(username);
		return (UserDetails) buildUsuario(usuario, buildAutoridadesConcedidas(usuario.getUsuarioRol()));
			}
	
	private User buildUsuario(Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isActivo(), true, true, true, grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildAutoridadesConcedidas(UsuarioRol usuarioRol) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		grantedAuthorities.add(new SimpleGrantedAuthority(usuarioRol.getRol()));
		
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
	
	
}
