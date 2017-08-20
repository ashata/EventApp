package org.hoboventures.wedding.web;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class ErrorHandleController implements ErrorViewResolver {

/*    @Override
    public String getErrorPath() {
        return "error";
    }

    @GetMapping(value = "error")
    public ModelAndView error(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("errors");
        return mav;
    }*/

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest httpServletRequest, HttpStatus httpStatus, Map<String, Object> map) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }

    /*@Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        return resolveErrorView(request, HttpStatus.valueOf(response.getStatus()), null);
    }*/

}
