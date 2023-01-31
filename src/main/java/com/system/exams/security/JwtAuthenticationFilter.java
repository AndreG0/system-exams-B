package com.system.exams.security;

import com.system.exams.service.Impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            String jwtToken = parseJwt(request);

            if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
                String username = jwtUtils.extractUsername(jwtToken);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.replace("Bearer ", "");

        }
        return null;
    }

}




        // String requestTokenHeader = request.getHeader("Authorization");
      //  String username = null;
       // String jwtToken = null;

     //  if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
        //    jwtToken = requestTokenHeader.substring(7);

       // try{
         //   username = this.jwtUtils.extractUsername(jwtToken);

       //  }catch (ExpiredJwtException exception){
        //    System.out.println("The token has expired");
      //  }catch (Exception e){
       //     e.printStackTrace();
       //  }
       // } else {
       // System.out.println("Invalid Token, does’t start with bearer string");
      // }

       // if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
       //     UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
       //     if(this.jwtUtils.validateToken(jwtToken,userDetails)){
        //        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
          //      usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

          //      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
         //   }
         //   else {
          //      System.out.println("Invalid Token");
         //   }

         //   filterChain.doFilter(request,response);
     //   }
  //  }

