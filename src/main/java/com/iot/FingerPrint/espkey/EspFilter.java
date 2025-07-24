package com.iot.FingerPrint.espkey;

import com.iot.FingerPrint.espdevice.EspDevice;
import com.iot.FingerPrint.espinmemorystore.EspKeyStore;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

//once a request come then filtering by means of key
@Component
public class EspFilter extends OncePerRequestFilter {
    private static final List<String> EXCLUDED_PATHS = List.of(
            "/swagger-ui/index.html",
            "/swagger-ui.html",
            "/v3/api-docs"
    );
    private final EspKeyStore apiKey;
    public EspFilter(EspKeyStore apiKey){
        this.apiKey=apiKey;
    }

    //filtering the incoming request to authenticate a devices
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String url=request.getRequestURI();

        if(isSwaggerRequest(url)){
            filterChain.doFilter(request,response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("ApiKey ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing or invalid API key");
            return;
        }

        String key = authHeader.substring(7);
        System.out.println(key);

        EspDevice device=apiKey.getByKey(key);
        System.out.println(device);
        //best option is to use optional object
        //save a request it means a request verified
        request.setAttribute("device",device);
        filterChain.doFilter(request,response);
    }

    private boolean isSwaggerRequest(String path){
        return EXCLUDED_PATHS.stream().anyMatch(path::startsWith);
    }
}
