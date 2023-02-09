package com.example.calculation.service;

import com.example.calculation.model.ActivityLog;
import com.example.calculation.model.LoginCred;
import com.example.calculation.model.User;

import java.util.List;

public interface ControlServiceInterface {
    List<User> getAllUser();
    User saveUser(User user);
    boolean checkValidUser(LoginCred loginCred);
    List<ActivityLog> getAllActivityLog();
    ActivityLog createActivity(String email);
    boolean checkActivityAssignedForStudent(String email);


//    static ActivityLog submitActivity(Long activityLogId, String input);
//    static int one(String calc);
//    static int two(String calc);
//    static int three(String calc);
//    static int four(String calc);
//    static int five(String calc);
//    static int six(String calc);
//    static int seven(String calc);
//    static int eight(String calc);
//    static int nine(String calc);
//    static String plus(String calc);
//    static String minus(String calc);
//    static String times(String calc);
//    static String divided_by(String calc);
//    static String one();
//    static String two();
//    static String three();
//    static String four();
//    static String five();
//    static String six();
//    static String seven();
//    static String eight();
//    static String nine();

}
