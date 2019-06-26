package com.github.aa76111;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleTest {
    private Rectangle rectangle;

    @Before
    public void setUp() {
        rectangle = new Rectangle(3, 4);
    }

    @Test
    public void should_get_perimeter() {
        //  given

        //  when

        //  then
        assertThat(rectangle.getPerimeter()).isEqualTo(14);
    }

    @Test
    public void should_get_area() {
        //  given

        //  when

        //  then
        assertThat(rectangle.getArea()).isEqualTo(12);
    }
}