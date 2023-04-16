package com.itwill.my_real_korea.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;
import com.itwill.my_real_korea.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	
/*	
 * 보류
 * 
	//회원 가입 액션
	@ApiOperation(value="회원 가입 액션")
	@PostMapping(value = "/user", produces = "application/json;charset=UTF-8")
	public Map<String, Object> user_write_action(@RequestBody User user) throws Exception {
		Map<String,Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		try {
			userService.create(user);
			userService.updateMailKey(user);
		} catch (Exception e) {
			e.printStackTrace();
			code = 2;
			msg = "이미 존재하는 아이디 입니다.";
			//error_code와 error_msg는 예외 발생 시 해당 예외에 대한 정보를 나타냄
			resultMap.put("error_code", code);
			resultMap.put("error_msg", msg);
		}
		//code와 msg는 API 호출 결과에 대한 정보를 의미
	    resultMap.put("code", code);
	    resultMap.put("msg", msg);
	    resultMap.put("data", user);
		return resultMap;
	}
*/	
	
	//로그인 액션
	@ApiOperation(value="로그인 액션")
	@PostMapping(value = "user-login", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Response user_login_action(@RequestBody User user, HttpServletRequest request) throws Exception {
	    HttpSession session = request.getSession();
	    Response res = new Response();
	    try {
	        User authUser = userService.login(user.getUserId(), user.getPassword());
	        if (authUser.getMailAuth() != 1) {
	            session.setAttribute("authUser", authUser);
	            res.setCode(1);
	            res.setMessage("이메일을 확인해주세요.");
	            res.setData("user-auth");
	        } else {
	            User loginUser = userService.login(user.getUserId(), user.getPassword());
	            session.setAttribute("loginUser", loginUser);
	            String prevPage = (String) session.getAttribute("prevPage");
	            System.out.println(">> prevPage : "+prevPage);
	            if (prevPage == null || prevPage.contains("/user-login") || prevPage.contains("/user-auth")) {
	                prevPage = request.getContextPath() + "/index";
	            }
	            session.removeAttribute("prevPage");
	            res.setCode(0);
	            res.setMessage("성공");
	            res.setData(prevPage);
	        }
	    } catch (UserNotFoundException e) {
	        e.printStackTrace();
	        res.setCode(2);
	        res.setMessage(e.getMessage());
	        session.setAttribute("prevPage", request.getHeader("Referer"));
	    } catch (PasswordMismatchException e) {
	        e.printStackTrace();
	        res.setCode(3);
	        res.setMessage(e.getMessage());
	        session.setAttribute("prevPage", request.getHeader("Referer"));
	    }
	    return res;
	}

	/***************************ID, Password 찾기********************************/

	//아이디 찾기 액션
	@PostMapping(value = "/user-find-id-action", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Response user_find_id_action(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
		Response response = new Response();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		String userId = userService.findIdByEmailName(email,name);
		if(userId != null) {
			response.setCode(1);
			response.setMessage("회원님의 아이디는 "+userId+" 입니다.");
			response.setData(userId);
		}else {
			response.setCode(2);
			response.setMessage("일치하는 회원 정보가 없습니다.");
		}
		return response;
	}
	
	//비밀번호 찾기 액션 (이메일로 임시 비밀번호 발송)
	@PostMapping(value = "/user-find-pw-action", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Response user_find_pw_action(@RequestParam("userId") String userId, @RequestParam("email") String email) throws Exception {
	    User user = new User();
	    user.setUserId(userId);
	    user.setEmail(email);
	    int matchCount = userService.findIdByIdEmail(userId, email);
	    Response response = new Response();
	    if(matchCount == 1) {
	        userService.sendTempPassword(userId, email);
	        response.setCode(1);
	        response.setMessage("이메일로 임시 비밀번호가 발송되었습니다.");
	    }else {
	        response.setCode(2);
	        response.setMessage("일치하는 회원 정보가 없습니다.");
	    }
	    return response;
	}
	/*********************************************************/

	
/*
 * 보류
 * 
	//회원 정보 보기
	@LoginCheck
	@GetMapping(value = "/user-view", produces = "application/json;charset=UTF-8")
	public Response user_view(@RequestParam(required = false) String userId, HttpServletRequest request) throws Exception {
	    Response response = new Response();
	    HttpSession session = request.getSession();

	    User loginUser = (User) session.getAttribute("loginUser");
	    if (loginUser == null) {
	        session.setAttribute("requestUrl", request.getRequestURL().toString());
	        response.setStatus(2);
	        response.setMessage("로그인이 필요한 기능입니다.");
	    } else {
	        if (userId == null) {
	            userId = loginUser.getUserId();
	        }
	        User user = userService.findUser(userId);
	        if (user == null) {
	            response.setStatus(2);
	            response.setMessage("해당 사용자가 존재하지 않습니다.");
	        } else {
	            response.setStatus(1);
	            response.setMessage("성공");
	            response.setData(user);
	        }
	    }
	    return response;
	}
 */
	

}





