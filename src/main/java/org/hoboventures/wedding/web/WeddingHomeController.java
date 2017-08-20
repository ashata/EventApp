package org.hoboventures.wedding.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.hoboventures.wedding.dto.FAQ;
import org.hoboventures.wedding.dto.Image;
import org.hoboventures.wedding.dto.WeddingHome;
import org.hoboventures.wedding.service.FAQService;
import org.hoboventures.wedding.service.ImageService;
import org.hoboventures.wedding.service.WeddingHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class WeddingHomeController {

    private static final Logger logger = LoggerFactory.getLogger(WeddingHomeController.class);

    @Autowired private WeddingHomeService weddingHomeService;
    @Autowired private FAQService faqService;
    @Autowired private ImageService imageService;

    @GetMapping(value = "home")
    public WeddingResponse home(){
        List<WeddingHome> list = weddingHomeService.findAll();
        WeddingResponse response = new WeddingResponse(list);
        return response;
    }

    @GetMapping(value = "/")
    public ModelAndView homeView(){
        ModelAndView mav = new ModelAndView();
        /*List<WeddingHome> list = weddingHomeService.findAll();
        mav.getModelMap().addAttribute(list);*/
        mav.setViewName("index");
        return mav;
    }

    @GetMapping(value = "saveFAQ")
    public List<FAQ> faqSave(){
        return faqService.save();
    }

    @GetMapping(value = "getPage")
    public List<FAQ> getPage(@RequestParam("path") String path){
        logger.info("path: " + path);
        if(StringUtils.equalsIgnoreCase(path, "faq")){
            return faqService.findAll();
        }
        else if(StringUtils.equalsIgnoreCase(path, "aboutUs")){
            return faqService.brideAndGroom();
        }
        return null;
    }

    @GetMapping(value = "slideshow")
    public List<Image> getImages(){
        return imageService.images();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException() {
        ModelAndView mav = new ModelAndView();
        /*List<WeddingHome> list = weddingHomeService.findAll();
        mav.getModelMap().addAttribute(list);*/
        mav.setViewName("error");
        return mav;
    }



    @Getter @Setter @ToString
    private class WeddingResponse{
        private List<FAQ> faq;
        private List<FAQ> aboutUs;

        private List<WeddingHome> cardList;

        public WeddingResponse(List<WeddingHome> cardList) {
            this.cardList = cardList;
           /* this.faq = faqService.findAll();
            this.aboutUs = faqService.brideAndGroom();*/
        }
    }
}
