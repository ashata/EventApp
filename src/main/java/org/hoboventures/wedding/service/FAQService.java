package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.FAQ;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
public interface FAQService {

    List<FAQ> findAll();

    List<FAQ> save();

    List<FAQ> brideAndGroom();
}
