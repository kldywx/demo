package com.util;

import com.DemoTestApplication;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoTestApplication.class)
public class DoWhile {

    @Test
    public void doWhile() {
        int size = 10;
        int all = 95;
        int nowPage = 0;
        int beLeftOverTimes = 0;
        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("before all : " + all);
            System.out.println("before nowPage : " + nowPage);
            System.out.println("before size : " + size);
            System.out.println("before beLeftOverTimes : " + beLeftOverTimes);

            System.out.println("do post 分页 : ");
            nowPage = nowPage + 1;
            beLeftOverTimes = all/size + (all%size==0?0:1) - nowPage;

            System.out.println("after all : " + all);
            System.out.println("after nowPage : " + nowPage);
            System.out.println("after size : " + size);
            System.out.println("after beLeftOverTimes : " + beLeftOverTimes);

        }while (beLeftOverTimes > 0);

    }

}
