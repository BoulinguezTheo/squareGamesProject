package com.example.squaregamesspring.security;

import com.example.squaregamesspring.dao.repository.UserRepository;
import com.example.squaregamesspring.dto.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");
        final String SIGNINGKEY = "e9sng4q";
        if (header != null) {
            if(header.startsWith("Bearer")) {
                //TODO : what do do ?
                final String token = header.split(" ")[1].trim();

                // On “parse” le token en utilisant la même clé de signature qui sera utilisée pour générer le token à l’authentification (“secret”)
                final Claims claims =
                        Jwts.parser().setSigningKey(SIGNINGKEY.getBytes()).parseClaimsJws(token).getBody();
                if (claims.getExpiration().after(new Date())) {
                    // On récupère le nom de l’utilisateur indiqué dans l’objet
                    final String username = claims.getSubject();
                    // On récupère les informations de l’utilisateur grâce au repository
                    final UserDetails userDetails = userRepository.findByUsername(username);
                    final UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails == null ? List.of() : userDetails.getAuthorities());
                    // Ajoute les informations de l’utilisateur
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // Met à jour le contexte d’authentification
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    // Important : permet à Spring de continuer le traitement !
                } else {
                    //TODO : WHAT TO DO ?
                    System.out.println("error DATE");
                }
            } else{
                System.out.println("error HEADER2");
            }
        } else {
            //TODO : WHAT TO DO ?
            System.out.println("error HEADER");
        }
        chain.doFilter(request, response);
    }

}
