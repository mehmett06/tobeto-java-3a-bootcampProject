package com.tobeto.bootcampproject.core.crosscuttingconcerns.logging.configurations.mongodb;

import com.tobeto.bootcampproject.core.crosscuttingconcerns.logging.LogDetail;
import com.tobeto.bootcampproject.core.crosscuttingconcerns.logging.LogParameter;
import com.tobeto.bootcampproject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.lang.reflect.Parameter;
import java.util.List;

@Service
public class MongoDbLogger extends LoggerServiceBase {
    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoDbLogger(MongoTemplate mongoTemplate){
        super(MongoDbLogger.class);
        this.mongoTemplate=mongoTemplate;
    }

    @Override
    public void log(String methodName, List<LogParameter> logParameters, String userName) {

        LogDetail detail=new LogDetail();
        detail.setMethodName(methodName);
        detail.setParameters(logParameters);
        detail.setUser(userName);
        info(detail.toString());
        mongoTemplate.save(detail);

    }
}
