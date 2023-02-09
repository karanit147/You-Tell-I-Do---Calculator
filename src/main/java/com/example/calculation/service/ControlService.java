package com.example.calculation.service;

import com.example.calculation.model.ActivityLog;
import com.example.calculation.model.LoginCred;
import com.example.calculation.model.User;
import com.example.calculation.repository.ActivityLogRepository;
import com.example.calculation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@Service
public class ControlService implements ControlServiceInterface {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private static ActivityLogRepository activityLogRepository;


	public ControlService(UserRepository userRepository, ActivityLogRepository activityLogRepository) {
		this.userRepository = userRepository;
		this.activityLogRepository = activityLogRepository;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public boolean checkValidUser(LoginCred loginCred) {
		List<User> allUSer =  getAllUser();
		for(User tempUser : allUSer ) {
			if(Objects.equals(tempUser.getEmail(), loginCred.getEmail())) {
//				email is registered, check for password
				if(Objects.equals(tempUser.getPassword(), loginCred.getPassword())) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public List<ActivityLog> getAllActivityLog() {
		return activityLogRepository.findAll();
	}

	public User findUserDetail(String email) {
		List<User> allUser = getAllUser();
		for(User tempUser : allUser) {
			if(Objects.equals(tempUser.getEmail(), email)) {
				return tempUser;
			}
		}
		return null;
	}

	public ActivityLog createActivity(String email) {
		ActivityLog temp = new ActivityLog();
		temp.setToStudentMailId(email);
		temp.setCompletionStatus(false);
		return activityLogRepository.save(temp);
	}

	public boolean checkActivityAssignedForStudent(String email) {
//		false means student is free, true meas already activity assigned to student
		boolean result = false;
		List<ActivityLog> allActivity = getAllActivityLog();
		for(ActivityLog temp : allActivity) {
			if(Objects.equals(temp.getToStudentMailId(), email)) {
				if(!temp.isCompletionStatus()) {
					result = true;
				} else {
					result = false;
				}
			}
		}
		return result;
	}

	public static ActivityLog submitActivity(Long activityLogId, String input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		ActivityLog temp = activityLogRepository.findById(activityLogId).orElseThrow();
		temp.setInputQuestion(input);

		String segments[] = input.split("\\(");
		String first = segments[0];
		String second = segments[1];
		String third = segments[2];

		Method m3 = ControlService.class.getDeclaredMethod(third);
		Object o3 = m3.invoke(null);


		Method m2 = ControlService.class.getDeclaredMethod(second, String.class);
		Object o2 = m2.invoke(null, o3);

		Method m1 = ControlService.class.getDeclaredMethod(first, String.class);
		Object o1 = m1.invoke(null,o2);

		System.out.println(o1);
		temp.setOutputResult(o1.toString());

		temp.setCompletionStatus(true);
		return activityLogRepository.save(temp);
	}


	public static int one(String calc) {
		String y = "1"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 1+Integer.parseInt(calc);
	}

	public static int two(String calc) {
		String y = "2"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 2+Integer.parseInt(calc);
	}

	public static int three(String calc) {
		String y = "3"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 3+Integer.parseInt(calc);
	}

	public static int four(String calc) {
		String y = "4"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 4+Integer.parseInt(calc);
	}

	public static int five(String calc) {
		String y = "5"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 5+Integer.parseInt(calc);
	}

	public static int six(String calc) {
		String y = "6"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 6+Integer.parseInt(calc);
	}

	public static int seven(String calc) {
		String y = "7"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 7+Integer.parseInt(calc);
	}

	public static int eight(String calc) {
		String y = "8"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 8+Integer.parseInt(calc);
	}

	public static int nine(String calc) {
		String y = "9"+calc;
		if(y.contains("times")) {
			String segments[] = y.split("times");
			return (Integer.parseInt(segments[0]))*(Integer.parseInt(segments[1]));

		} else if(y.contains("divided_by")) {
			String segments[] = y.split("divided_by");
			return (Integer.parseInt(segments[0]))/(Integer.parseInt(segments[1]));

		}
		return 9+Integer.parseInt(calc);
	}

	public static String plus(String calc) {
		return "+"+calc;
	}

	public static String minus(String calc) {
		return "-"+calc;
	}

	public static String times(String calc) {
		return "times"+calc;
	}

	public static String divided_by(String calc) {
		return "divided_by"+calc;
	}

	public static String one() {
		return "1";
	}

	public static String two() {
		return "2";
	}

	public static String three() {
		return "3";
	}

	public static String four() {
		return "4";
	}

	public static String five() {
		return "5";
	}

	public static String six() {
		return "6";
	}

	public static String seven() {
		return "7";
	}

	public static String eight() {
		return "8";
	}

	public static String nine() {
		return "9";
	}

}
