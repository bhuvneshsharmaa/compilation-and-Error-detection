package com.reactiveongo.testingforreactivemongorepository.service;

import com.reactiveongo.testingforreactivemongorepository.model.User;
import com.reactiveongo.testingforreactivemongorepository.repo.BlockingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;
import java.util.UUID;

@Service
public class CompilerService {
    @Autowired
    private  BlockingRepository blockingRepository;
//    CompilerService (BlockingRepository blockingRepository){
//        this.blockingRepository=blockingRepository;
//    }
    public String runCode(String code,String lang,String input) throws IOException {
        blockingRepository.save(new User(UUID.randomUUID().toString(),code,input,null,null,lang));
        String timeStamp = String.valueOf(new Date().getTime());
        String inputFile = "i"+timeStamp+".txt";
        String codeFile = "c"+timeStamp+".txt";
        FileWriter fileWriter = new FileWriter(inputFile);
        fileWriter.write(input);
        fileWriter.flush();
        FileWriter codeFileWriter = new FileWriter(codeFile);
        codeFileWriter.write(code);
        codeFileWriter.flush();
        Process process=Runtime.getRuntime()
                .exec("sh comp.sh "+lang+" "+timeStamp);
        BufferedReader stdError=new BufferedReader(new InputStreamReader(process.getErrorStream()));
        BufferedReader stdInput=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s,ans="";
        boolean error=false;
        while ((s = stdError.readLine()) != null) {
            error=true;
            ans+=s;
            System.out.print(s);
        }
        if(error)
            return ans;
        ans="";
        while((s=stdInput.readLine())!=null){
            ans+=s;
            System.out.println(s);
        }
        return ans;
     }
}
