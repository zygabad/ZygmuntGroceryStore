package com.zygstore.dto;

import com.zygstore.business.ContactMessageBean;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ContactDTO {
    private ContactMessageBean contactMessageBean;

    public ContactDTO() {
    }

    public ContactDTO(ContactMessageBean contactMessageBean) {
        this.contactMessageBean = contactMessageBean;
    }

    public ContactMessageBean getContactMessageBean() {
        return contactMessageBean;
    }

    public void setContactMessageBean(ContactMessageBean contactMessageBean) {
        this.contactMessageBean = contactMessageBean;
    }


}
