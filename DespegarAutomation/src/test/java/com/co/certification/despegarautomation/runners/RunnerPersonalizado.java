package com.co.certification.despegarautomation.runners;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.cucumber.CucumberWithSerenity;

public class RunnerPersonalizado extends Runner {

  private Class<CucumberWithSerenity> classValue;
  private CucumberWithSerenity cucumberWithSerenity;
  private static final Logger LOGGER = LoggerFactory.getLogger(RunnerPersonalizado.class);

  public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws InitializationError, IOException {
    this.classValue = classValue;
    cucumberWithSerenity = new CucumberWithSerenity(classValue);
  }

  @Override
  public Description getDescription() {
    return cucumberWithSerenity.getDescription();
  }

  private void runAnnotatedMethods(Class<?> annotation)
    throws IllegalAccessException, InvocationTargetException {
    if (!annotation.isAnnotation()) {
      return;
    }
    Method[] methods = this.classValue.getMethods();
    for (Method method : methods) {
      Annotation[] annotations = method.getAnnotations();
      for (Annotation item : annotations) {
        if (item.annotationType().equals(annotation)) {
          method.invoke(null);
          break;
        }
      }
    }
  }

  @Override
  public void run(RunNotifier notifier) {
    try {
      runAnnotatedMethods(BeforeSuite.class);
      cucumberWithSerenity = new CucumberWithSerenity(classValue);
    }
    catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }
    cucumberWithSerenity.run(notifier);
  }
}

