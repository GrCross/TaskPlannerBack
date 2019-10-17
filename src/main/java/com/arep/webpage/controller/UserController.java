package com.arep.webpage.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.arep.webpage.config.Token;
import com.arep.webpage.exceptions.NotFoundException;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import com.arep.webpage.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping(value = "/taskPlanner")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping( value = "/user/login", method = RequestMethod.POST )
    public Token login(@RequestBody User login )
            throws ServletException
    {
        System.out.println(login);
        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.consultarUsuarioPorCorreo(email);

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( email ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> recursoConsultarUsuarios() throws NotFoundException {
        try {
            List<User> usuarios = userService.consultarUsuarios();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> recursoConsultarUsuarioPorCorreo(@PathVariable String email)
            throws NotFoundException {
        try {
            User usuario = userService.consultarUsuarioPorCorreo(email);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/users/{email}/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> recursoConsultarTasksUsuarioPorCorreo(@PathVariable String email)
            throws NotFoundException {
        try {
            List<Task> tasks = userService.consultarTasksPorCorreo(email);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/users/{email}/tasks/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> recursoConsultarTaskUsuarioPorCorreoId(@PathVariable String email,@PathVariable Integer id)
            throws NotFoundException {
        try {
            Task task = userService.consultarTaskPorIdCorreo(email,id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }




    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity<?> recursoCrearUsuario(@RequestBody User user) {
        try {
            
            userService.agregarUsuario(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


    @RequestMapping(value = "/users/{email}/tasks", method = RequestMethod.POST)
    public ResponseEntity<?> recursoCrearTask(@PathVariable String email, @RequestBody Task task) {
        try {
            userService.agregarTask(email,task);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    

}
