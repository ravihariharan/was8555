package com.lean.demo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TestView2 implements Serializable
{
    private String testString;

    @Inject
    QuestionnaireSessionData questionnaireSessionData;

    public TestView2()
    {
        super();
        System.out.println("TestView constructor");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("TestView init");
        testString = "Welcome to PrimeFaces!!!";

        testString = testString + questionnaireSessionData.getMsg();
        System.out.println("TestView init " + questionnaireSessionData.getMsg());
    }

    public String getTestString()
    {
        return testString;
    }

    public void setTestString(String testString)
    {
        this.testString = testString;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSayWelcome()
    {
        System.out.println("getSayWelcome");
        // check if null?
        if ("".equals(name) || name == null)
        {
            return "";
        } else
        {
            return "Ajax message : Welcome " + name;
        }
    }
}
