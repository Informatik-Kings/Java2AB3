package de.fhswf.fbin.java2fx.validation;

import javafx.beans.value.ChangeListener;

public interface Validator<T> extends ChangeListener<T>
{
  public boolean isValid(T value);
  public boolean validate(T value);

  // support StatusListeners
  public void addStatusListener(StatusListener<T> l);
  public void removeStatusListener(StatusListener<T> l);
}
