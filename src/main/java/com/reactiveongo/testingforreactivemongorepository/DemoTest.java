package com.reactiveongo.testingforreactivemongorepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoTest implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(DemoTest.class, args);
    }
    @Override
    public void run(String args[]) throws IOException {
//        String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//
//      Process process=Runtime.getRuntime()
//                .exec("gcc -w file.c -o "+timestamp+".out");
//        BufferedReader stdError=new BufferedReader(new InputStreamReader(process.getErrorStream()));
//        String log="",s;
//        boolean error=false;
//        while ((s = stdError.readLine()) != null) {
//            log+=s;
//            error=true;
//            log+="\n";
//        }
//        if(error==false)
//            System.out.println("compilation successful");
//        else
//            System.out.println("error present" +log);
//        if(error==false){
//            String currtimestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//
//             process=Runtime.getRuntime()
//                    .exec("timeout 5s ./"+timestamp +".out >"+currtimestamp+".txt");
//            BufferedReader output=new BufferedReader(new InputStreamReader(process.getInputStream()));
//            System.out.println("here is the output");
//            while ((s=output.readLine())!=null){
//                System.out.println(s);
//            }
//        }
    }

}
