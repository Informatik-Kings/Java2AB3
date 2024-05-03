package de.fhswf.fbin.java2fx.validation;

public interface StatusListener<T>
{
   public void stateChanged(StatusEvent<T> e);
}
