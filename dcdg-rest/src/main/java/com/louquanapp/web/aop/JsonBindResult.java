package com.louquanapp.web.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.model.PageJsonResult;
import com.louquanapp.model.TypeJsonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 14:17
 * @Modified By:
 * @Since:
 */
@Aspect
@Component
@Order(1)
public class JsonBindResult {

//    public static String sortDict(JSONObject json) {
//        StringBuilder builder = new StringBuilder();
//        List<String> list1 = new ArrayList<String>();
//        list1.addAll(json.keySet());
//        Collections.sort(list1);
//        for (int i = 0; i < list1.size(); i++) {
//            char ch = ' ';
//            if (i < list1.size() - 1) {
//                if (list1.get(i).equals("sign"))
//                    continue;
//                ch = '&';
//
//            }
//
//            if (null != json.get(list1.get(i)) && StringUtils.isNotEmpty(json.get(list1.get(i)).toString())) {
//                builder.append(list1.get(i) + "=" + json.get(list1.get(i)).toString() + ch);
//            }
//
//        }
//        if (builder.toString().lastIndexOf("&") + 1 == builder.toString().length()) {
//            return builder.toString().trim().substring(0, builder.length() - 1);
//        }
//        return builder.toString().trim();
//    }

    @Around("execution(* com.louquanapp.web.*.api..*.*(..)) && args(..,reqSource,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, Object reqSource, BindingResult bindingResult) throws Throwable {
        Object retVal;
        JSONObject jsonObject = (JSONObject) JSON.toJSON(reqSource);
//        String signStr = sortDict(jsonObject);
//        String sign = DigestUtils.md5Hex(signStr);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Class<?> returnType = methodSignature.getReturnType();
//        if (!jsonObject.get("sign").toString().equalsIgnoreCase(sign)) {
//            return doErrorHandle("签名错误", returnType);louquanapp
//        }
        if (null != bindingResult && bindingResult.hasErrors()) {
            retVal = doErrorHandle(bindingResult.getAllErrors().get(0).getDefaultMessage(), returnType);
        } else {
            retVal = pjp.proceed();
        }
        return retVal;
    }

    private Object doErrorHandle(String msg, Class returnType) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        //response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        if (returnType.getName().equals("com.louquanapp.model.PageJsonResult")) {
            PageJsonResult<Object> pageJsonResult = new PageJsonResult<>();
            pageJsonResult.setStatusCode(false);
            pageJsonResult.setMessage(msg);
            return pageJsonResult;
        }

        if (returnType.getName().equals("com.louquanapp.model.TypeJsonResult")) {
            TypeJsonResult<Object> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            typeJsonResult.setMessage(msg);
            return typeJsonResult;
        }


        JsonResult jsonResult = new JsonResult(false);

        if (msg.equals("token不能为空")) {
            jsonResult.setCode(302);
        }
        jsonResult.setMessage(msg);
        return jsonResult;
    }


}


