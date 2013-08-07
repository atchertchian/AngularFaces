package de.beyondjava.jsf.sample.datatable

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

public class Car
{
   @Min(1000l)
   @Max(20000l)
   @NotNull
   long price
   @Min(1870L)
   @Max(2020L)
   int year
   @NotNull
   @Size(min=3, max=10)
   String manufacturer
   @NotNull
   @Size(min=3, max=7)
   String color
   @Max(10L)
   int quantity=0


   public Car(long price, int year, String manufacturer, String color)
   {
      this.price = price
      this.year = year
      this.manufacturer = manufacturer
      this.color = color
   }
}
