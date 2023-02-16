package com.example.rest.services;

import com.example.rest.entities.Role;
import com.example.rest.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Integer roleId,Role role){
        Optional<Role> result = roleRepository.findById(roleId);
        if(result.isPresent()){
            return roleRepository.save(role);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role_id %d doesn't exist",roleId));
        }
    }

    public void deleteRole(Integer roleId) {
        Optional<Role> result = roleRepository.findById(roleId);
        if(result.isPresent()){
            roleRepository.delete(result.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role_id %d doesn't exist",roleId));
        }
    }
}
