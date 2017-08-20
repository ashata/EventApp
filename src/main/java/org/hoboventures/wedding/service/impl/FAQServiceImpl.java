package org.hoboventures.wedding.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hoboventures.wedding.dao.FAQRepository;
import org.hoboventures.wedding.dao.RSVPRepository;
import org.hoboventures.wedding.dto.FAQ;
import org.hoboventures.wedding.dto.RSVP;
import org.hoboventures.wedding.service.FAQService;
import org.hoboventures.wedding.service.RSVPService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class FAQServiceImpl implements FAQService {

    @Resource private FAQRepository faqRepository;


    @Override
    public List<FAQ> findAll() {
        return faqRepository.findAll();
    }

    private List<FAQ> prepare(List<FAQ> all) {
        if(!CollectionUtils.isEmpty(all)){
            for (FAQ faq : all) {
                if(faq != null && StringUtils.containsIgnoreCase(faq.getQuestion(), "link here")){
                    String question = StringUtils.replaceAll(faq.getQuestion(),"link here", "<a href='"
                            + faq.getLink() + "'> page </a>");
                    faq.setQuestion(question);
                }
                if(faq != null && StringUtils.containsIgnoreCase(faq.getAnswer(), "link here")){
                    String answer = StringUtils.replaceAll(faq.getAnswer(),"link here", "<a href='" +
                            faq.getLink() + "'> page </a>");
                    faq.setAnswer(answer);
                }
            }
        }
        return all;
    }

    @Override
    public List<FAQ> save() {
        List<FAQ> faqList = new ArrayList<>();

        String question = "Where is the wedding happening";
        String answer = "Ceremony and Reception is held at Kelly Gallery Gardens, Overland Park, KS. https://thekellygallerygardens.com/.<br> It is an outdoor wedding in Fall Season. Please check our directions page link here to plan your trip.";
        String link = "directions.html";
        FAQ faq = new FAQ(question, answer, link);
        faqList.add(faq);

        String question2 = "Is it an indoor/outdoor ceremony";
        String answer2 = "It is an outdoor ceremony. Rain or shine, its our day, we will love it with you by our side.<br> Ceremony will be outdoor and reception in the wedding tent. We can roll the tent walls down and turn the heater on\n" +
                "    in case of bad weather.";
        String link2 = "";
        FAQ faq2 = new FAQ(question2, answer2, link2);
        faqList.add(faq2);

        String question3 = "What time is the wedding held";
        String answer3 = "<span> 1 p.m to 7 p.m</span><br>\n" +
                "    <span>Guests start to arrive: 1 p.m</span><br>\n" +
                "    <span>Guests sign in and are seated: 1.40 pm</span><br>\n" +
                " <span>Groom's carriage arrival: 2 p.m</span><br>\n" +
                "    <span>Bride walks down: 2.10 pm</span><br>\n" +
                "    <span>Ceremony ends: 3 p.m</span><br>\n" +
                "    <span>Cocktail hour/pictures: 3 -4 p.m. Appetizers available</span><br>\n" +
                " <span>Reception: 4 - 7 p.m. Food will be served at 4. </span><br>\n" +
                "    <span>Arrive before 1.30 p.m C.S.T (not IST or Y(your)ST). Please check our Wedding program (to be announced in September) to get detailed outline of our ceremony and reception.</span><br>\n";
        String link3 = "";
        FAQ faq3 = new FAQ(question3, answer3, link3);
        faqList.add(faq3);

        String question4 = "What type of wedding is this";
        String answer4 = "This is a place where our cultures and families come together. We are creating a blend of Indian and Western ceremony by bringing different pieces/aspects from both cultures.<br> Reception will be in western style.\n" +
                "    Ceremony and reception are both held at the same place and we will serve appetizers during the cocktail hour.<br> There will be plenty of good food, drinks, music, dance and cake to keep everyone content.";
        String link4 = "";
        FAQ faq4 = new FAQ(question4, answer4, link4);
        faqList.add(faq4);

        String question5 = "What are the bride's colors";
        String answer5 = "Beautiful bride will be wearing a \"Dark Red and Ivory\" dress. <br>I know there are a lot of reds and oranges and to give an idea, Bride will be in the (Maroon/dark red/burgundy) range.";
        String link5 = "";
        FAQ faq5 = new FAQ(question5, answer5, link5);
        faqList.add(faq5);

        String question6 = "What are the groom's colors";
        String answer6 = "Groom will be wearing a light Grey suit with his groomsmen.";
        String link6 = "";
        FAQ faq6 = new FAQ(question6, answer6, link6);
        faqList.add(faq6);

        String question7 = "What are wedding colors/theme";
        String answer7 = "Fall Colors, nature, outdoors. Put on your favorite dress and head on. My bridesmaids will be wearing Blue dresses, flower girl in white and blue, groomsmen in light grey and our ring bearer in blue.";
        String link7 = "";
        FAQ faq7 = new FAQ(question7, answer7, link7);
        faqList.add(faq7);

        String question8 = "What are the wedding flowers and their colors";
        String answer8 = "Various fall flowers/twigs featuring roses and baby's breath";
        String link8 = "";
        FAQ faq8 = new FAQ(question8, answer8, link8);
        faqList.add(faq8);

        String question9 = "Where should I park";
        String answer9 = "There is plenty of FREE parking at the venue and it's an open space, easy to find and there will also be directions when you arrive.";

        String link9 = "";
        FAQ faq9 = new FAQ(question9, answer9, link9);
        faqList.add(faq9);

        String question10 = "What kind of music will be played";
        String answer10 = "We are creating a mix of classical western, pop and bollywood songs and scores for our special day. There will be DJ for reception and acoustic music for ceremony";
        String link10 = "";
        FAQ faq10 = new FAQ(question10, answer10, link10);
        faqList.add(faq10);

        String question11 = "What type of food and alcohol";
        String answer11 = "Meat, vegetarian, vegan everyone will have something to eat. We will serve beer and wine, no cash bar.";
        String link11 = "";
        FAQ faq11 = new FAQ(question11, answer11, link11);
        faqList.add(faq11);

        String question12 = "Is there a dress code/shoe that I need to follow";
        String answer12 = "Informal,bring your flair, keep in mind the october weather in Kansas and dress according to that day.<br> Wedding families will be dressed in Indian and Western outfits.<br>\n" +
                "                Since the wedding is outdoors, high heels/Stilletos may not be ideal if it has rained recently.";
        String link12 = "";
        FAQ faq12 = new FAQ(question12, answer12, link12);
        faqList.add(faq12);

        String question13 = "Are kids welcome";
        String answer13 = "Well behaved kids are welcome because come' on who doesn't like them? ;).<br> Bride's neice and nephew are 5-10 years old and there will be other under 21 year olds from the wedding families. ";
        String link13 = "";
        FAQ faq13 = new FAQ(question13, answer13, link13);
        faqList.add(faq13);

        String question14 = "When is the RSVP deadline";
        String answer14 = "Please RSVP link here by Aug 31st to give us time to get the guest counts to our caterer and other vendors.";
        String link14 = "";
        FAQ faq14 = new FAQ(question14, answer14, link14);
        faqList.add(faq14);

        String question15 = "Are the ceremony and reception wheelchair accessible";
        String answer15 = "There is a small road pathway but most of the venue is a garden with uneven grassy land. There will be no steps to climb.";
        String link15 = "";
        FAQ faq15 = new FAQ(question15, answer15, link15);
        faqList.add(faq15);

        String question16 = "I am coming from out of town, where should I stay?";
        String answer16 = "Please check our Directions and Activities page link here for details.";
        String link16 = "";
        FAQ faq16 = new FAQ(question16, answer16, link16);
        faqList.add(faq16);

        String question17 = "Are there any pre-wedding activities";
        String answer17 = " <span>There will be Mehndi/Henna tattoo for the bride and bridal party 2 days before the wedding.<br> People interested are welcome to attend and you can get henna tattoo for discounted price.</span><br>\n" +
                "    <span>Contact us if you would like to be in Bridal/Groom's dance party or if you want to attend bachelor(ette), bridal showers etc that take place. </span><br>\n ";
        String link17 = "";
        FAQ faq17 = new FAQ(question17, answer17, link17);
        faqList.add(faq17);


        String question18 = "Is there a gifts registry";
        String answer18 = "Please check our registry page for information.";
        String link18 = "registry.html";
        FAQ faq18 = new FAQ(question18, answer18, link18);
        faqList.add(faq18);

        String question19 = "Can I take pictures";
        String answer19 = "We kindly ask guests to keep the phones/cameras away during the ceremony. There will be photo/videographers on site. You're welcome to take pictures other than the ceremony.";
        String link19 = "";
        FAQ faq19 = new FAQ(question19, answer19, link19);
        faqList.add(faq19);

        String question20 = "Will last names be changing after the wedding";
        String answer20 = "Yes";
        String link20 = "";
        FAQ faq20 = new FAQ(question20, answer20, link20);

        faqList.add(faq20);

        String question21 = "Are restrooms available at the venue";
        String answer21 = "Yes, unisex";
        String link21 = "";
        FAQ faq21 = new FAQ(question21, answer21, link21);
        faqList.add(faq21);

        String question22 = "I have a question not answered here; how do I contact you";
        String answer22 = " You can reach us by <email> contact us link";
        String link22 = "";
        FAQ faq22 = new FAQ(question22, answer22, link22);
        faqList.add(faq22);

        String question24 = "What if I want to donate my services instead of a gift";
        String answer24 = " You can reach us by <email> contact us link.<br>You're definitely welcome to do that as long as your service is not the type where '(in Friends)Phoebe wants to sing at your formal event'";
        String link24 = "aboutUs.html";
        FAQ faq24 = new FAQ(question24, answer24, link24);
        faqList.add(faq24);

        String type = "aboutUs";

        String question25 = "Bride: Asha";
        String answer25 = "I was born and raised in India, grew up in different parts of South India near Bangalore. I came to the US as a student and started working in KC where I met Charlie.";
        String link25 = "";
        FAQ faq25 = new FAQ(question25, answer25, link25);
        faq25.setType(type);
        faqList.add(faq25);

        String question26 = "Groom: Charlie";
        String answer26 = "I was born and raised in KC area, US. I went to KU and started working after graduation where I met Asha.";
        String link26 = "";
        FAQ faq26 = new FAQ(question26, answer26, link26);
        faq26.setType(type);
        faqList.add(faq26);

        String question27 = "How we met";
        String answer27 = "At work. We got to know each other before we started dating and knew this was more than an office affair.<br> We took the time to get to know the many shades of each other before jumping the marriage bandwagon.\n" +
                "\tDuring this time, we have built trust, love and dream and are now tying the knot.";
        String link27 = "rsvp.html";
        FAQ faq27 = new FAQ(question27, answer27, link27);
        faq27.setType(type);
        faqList.add(faq27);

        String question28 = "Our wedding";
        String answer28 = "<p>It will be a Fall outdoor wedding where we bring cultures and rituals from both traditions and create an event that means a lot to us.</p>\n" +
                " <p>Please refer FAQ link here page and check back in September for a detailed wedding program</p>";
        String link28 = "ceremonyProgram.html";
        FAQ faq28 = new FAQ(question28, answer28, link28);
        faq28.setType(type);
        faqList.add(faq28);

        String question29 = "Contact us";
        String answer29 = "<p>phone:913-205-4593<br>" +
                "                   913-553-8517</p>\n" +
                "<p>email:charlie.mehrer@gmail.com<br>" +
                "         asha.myid@gmail.com</p>";
        String link29 = "";
        FAQ faq29 = new FAQ(question29, answer29, link29);
        faq29.setType(type);
        faqList.add(faq29);

        return faqRepository.save(faqList);
    }

    @Override
    public List<FAQ> brideAndGroom() {
        return faqRepository.brideAndGroom();
    }
}
