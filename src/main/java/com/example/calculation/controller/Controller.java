package com.example.calculation.controller;

import com.example.calculation.model.ActivityLog;
import com.example.calculation.model.LoginCred;
import com.example.calculation.model.User;
import com.example.calculation.service.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

    @Autowired
    private ControlService controlService;

    @GetMapping("/getUserList/{role}")
    public List<User> getUserList(@PathVariable int role) {
//        0 is student,  1 is master, 2 is all
        List<User> allUser = controlService.getAllUser();
        List<User> studentList = new ArrayList<>();
        List<User> masterList = new ArrayList<>();

        for(User temp : allUser) {
            if(Objects.equals(temp.getRole(), "student")) {
                studentList.add(temp);
            } else {
                masterList.add(temp);
            }
        }

        if(role == 0) {
            return studentList;
        } else if(role ==1) {
            return masterList;
        }
        return controlService.getAllUser();
    }

    @PostMapping("/signUp")
    public User registerUser(@RequestBody User user) {
        List<User> allUser = controlService.getAllUser();
        for(User temp : allUser) {
            if(Objects.equals(user.getEmail(), temp.getEmail())) {
                throw new RuntimeException("Id Already exist");
            }
        }
        return controlService.saveUser(user);
    }

    @PostMapping("/login")
    public boolean userLogin(@RequestBody LoginCred loginCred) {
        return controlService.checkValidUser(loginCred);
    }

    @GetMapping("/activityLog")
    public List<ActivityLog> getActivityLog() {
        return controlService.getAllActivityLog();
    }

    @GetMapping("/activityLog/{email}")
    public List<ActivityLog> getSpecificActivityLog(@PathVariable String email) {
        List<ActivityLog> allActivityList = controlService.getAllActivityLog();
        List<ActivityLog> mySpecificActivityLog = new ArrayList<>();
        for(ActivityLog temp : allActivityList) {
            if(Objects.equals(temp.getToStudentMailId(), email)) {
                mySpecificActivityLog.add(temp);
            }
        }
        return mySpecificActivityLog;
    }

    @GetMapping("/askStudent/{email}")
    public ActivityLog createAskStudent(@PathVariable String email) {
//        this below 3 line used to ignore multiple activity at same time
//        if(controlService.checkActivityAssignedForStudent(email)){
//            throw new RuntimeException("Student already assigned");
//        }
        return controlService.createActivity(email);
    }

    @GetMapping("/submitActivity/{activityLogId}/{input}")
    public ActivityLog submitInputActivity(@PathVariable Long activityLogId ,@PathVariable String input) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return controlService.submitActivity(activityLogId, input);
    }

    @GetMapping("findUserDetail/{email}")
    public User findUserDetail(@PathVariable String email) {
        return controlService.findUserDetail(email);
    }

}