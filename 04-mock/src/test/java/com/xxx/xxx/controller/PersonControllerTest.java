package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Objects;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Test
    public void should_get_name() {
        String name = "ydx";
        //  given
        Person person = new Person("y", "dx", new BigDecimal("123"));
        given(personService.find(argThat(argument -> Objects.equals(argument.getName(), name)))).willReturn(person);

        //  when
        String fullName = personController.getName(name);

        //  then
        assertThat(fullName).isEqualTo("y,dx");
    }
}