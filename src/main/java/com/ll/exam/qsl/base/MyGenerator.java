package com.ll.exam.qsl.base;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class MyGenerator implements IdentifierGenerator {
    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String randomId = "Q" + format.format(today) + randomNum;
        return randomId;
    }
}
