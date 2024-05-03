package de.fhswf.fbin.java2fx.validation;

public class StatusEvent<T>
{
   private boolean status;
   private T value;
   
   public StatusEvent(T value, boolean status)
   {
      super();
      this.status = status;
      this.value = value;
   }
   
   public boolean isStatus()
   {
      return status;
   }
   
   public T getValue()
   {
      return value;
   }
}
