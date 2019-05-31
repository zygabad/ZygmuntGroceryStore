package com.zygstore.business;

import java.io.IOException;


import javax.mail.MessagingException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.zygstore.dto.ContactMessageDTO;
import com.zygstore.navigation.Result;
import com.zygstore.service.ContactMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactMessageBeanTest {

    @Mock
    ClassPathXmlApplicationContext ctx;

    @Mock
    ContactMessageService contactMessageService;

    @InjectMocks
    ContactMessageBean contactMessageBean;

    @Test
    public void sendResult() throws IOException, MessagingException {
        // given
        when(ctx.getBean(ContactMessageService.class)).thenReturn(contactMessageService);
        doNothing().when(contactMessageService).send(any(ContactMessageDTO.class), anyString());

        // when
        Result result = contactMessageBean.send();

        // then
        assertEquals(Result.SUCCESS, result);
    }
}