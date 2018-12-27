package com.marin.job.listing.web.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";
    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    public ModelAndView error(WebRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        ErrorJson error = new ErrorJson(response.getStatus(), getErrorAttributes(request, true));
        modelAndView.addObject("StatusType", "StatusType is : " + error.getStatus());
        modelAndView.addObject("ErrorType", "ErrorType is : " + error.getError());
        modelAndView.addObject("TraceType", "TraceType is : " + error.getTrace());
        modelAndView.addObject("TimeStampType", "TimeStampType is : " + error.getTimeStamp());
        modelAndView.addObject("MessageType", "MessageType is : " + error.getMessage());
        modelAndView.setViewName("accessDenied");
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }


    private Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(request, includeStackTrace);
    }
}
