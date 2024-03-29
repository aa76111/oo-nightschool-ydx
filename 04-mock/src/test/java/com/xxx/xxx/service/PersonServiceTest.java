package com.xxx.xxx.service;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TimeUnit.class)
@SuppressStaticInitializationFor("com.xxx.xxx.utils.SalaryCalculator")//阻止静态代码块运行
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Test
    public void should_return_person_successfully() {
        //  given
        PowerMockito.mockStatic(TimeUnit.class);
        PowerMockito.doNothing().when(TimeUnit.class);
        PersonRequest request = new PersonRequest("James");

        //  when
        Person person = personService.find(request);

        //  then
        assertThat(person).isEqualToComparingFieldByField(new Person("Merson", "James", new BigDecimal("20")));
    }

    @Test
    public void should_return_none_person() {
        //  given
        PersonRequest request = new PersonRequest("ydx");

        //  when
        Person person = personService.find(request);

        //  then
        assertThat(person).isEqualToComparingFieldByField(new Person("None", "None", BigDecimal.ZERO));
    }
}