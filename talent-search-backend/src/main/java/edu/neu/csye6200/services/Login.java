package edu.neu.csye6200.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.models.HiringManager;
import edu.neu.csye6200.repositories.HiringManagerRepository;

@Service
public class Login{
    @Autowired 
    HiringManagerRepository hiringManagerRepository;

    public HiringManager login(String username, String password) {
        List<HiringManager> managerList = hiringManagerRepository.findAll();
        System.out.println("Entered" + managerList);
        for (HiringManager manager : managerList) {
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                if (manager.getId() != null) {
                	manager.setRefrenceId(manager.getId().toString());
                    System.out.println("Logged in manager ID: " + manager.getId().toString());
                }
               
                return manager;
            }
        }
        return null;
    }
}