package de.fhswf.fbin.java2fx.validation;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ObservableValue;

public abstract class ValidationAdapter<T> implements Validator<T>
{
   private List<StatusListener<T>> listeners;

   private boolean wasValid = true;

   // Partial implementation of interface Validator
   public boolean validate(T value)
   {
      boolean isValidNow = isValid(value);
      if (isValidNow != wasValid)
      { // state changed
         fireChangedEvent(value, isValidNow);
         wasValid = isValidNow;
      }
      return (isValidNow);
   }

   // Implementation of interface ChangeListener<T>
   @Override
   public void changed(ObservableValue<? extends T> observable, T oldValue,
         T newValue)
   {
      validate(newValue);
   }

   // Support for StatusListeners
   public void addStatusListener(StatusListener<T> l)
   {
      if (listeners == null)
         listeners = new ArrayList<>();

      listeners.add(l);
   }

   public void removeStatusListener(StatusListener<T> l)
   {
      if (listeners != null)
         listeners.remove(l);
   }

   public void fireChangedEvent(T value, boolean status)
   {

      if (listeners != null)
      {
         StatusEvent<T> event = new StatusEvent<T>(value, status);
         for (StatusListener<T> sl : listeners)
         {
            sl.stateChanged(event);
         }
      }
   }
}
