package com.dfire.api;

import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.ArrayList;


/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 19:53 2018/3/28
 * @desc
 */
public class LombokTest {

    @Data
    @EqualsAndHashCode(exclude={"id", "shape"})
    public class EqualsAndHashCodeExample {
        private transient int transientVar = 10;
        private int id;
        private String name;
        private double score;
        private Shape shape = new Square(5, 10);
        private String[] tags;


        @EqualsAndHashCode(callSuper=true)
        public  class Square extends Shape {
            private final int width, height;

            public Square(int width, int height) {
                this.width = width;
                this.height = height;
            }
        }
    }

    @Test
    public void deepEqualsTest() {
        EqualsAndHashCodeExample e1 = new EqualsAndHashCodeExample();
        EqualsAndHashCodeExample e2 = new EqualsAndHashCodeExample();
        e1.setId(1);
        e2.setId(2);
        System.out.println(e1.equals(e2));

        List<EqualsAndHashCodeExample> list1 = new ArrayList<>();
        List<EqualsAndHashCodeExample> list2 = new ArrayList<>();
        list1.add(e1);
        list1.add(e2);

        list2.add(e2);
        list2.add(e1);
        System.out.println(Arrays.deepEquals(list1.toArray(), list2.toArray()));

    }
}
