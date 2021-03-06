package de.beyondjava.jsf.sample.datatable
import javax.faces.application.FacesMessage
import javax.faces.bean.ManagedBean
import javax.faces.bean.SessionScoped
import javax.faces.context.FacesContext

import org.primefaces.event.CellEditEvent

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {

   String[] colors

   String[] manufacturers

   List<Car> carsSmall

   public TableBean() {
      colors = new String[10]
      colors[0] = "Black"
      colors[1] = "White"
      colors[2] = "Green"
      colors[3] = "Red"
      colors[4] = "Blue"
      colors[5] = "Orange"
      colors[6] = "Silver"
      colors[7] = "Yellow"
      colors[8] = "Brown"
      colors[9] = "Maroon"

      manufacturers = new String[10]
      manufacturers[0] = "Mercedes"
      manufacturers[1] = "BMW"
      manufacturers[2] = "Volvo"
      manufacturers[3] = "Audi"
      manufacturers[4] = "Renault"
      manufacturers[5] = "Opel"
      manufacturers[6] = "Volkswagen"
      manufacturers[7] = "Chrysler"
      manufacturers[8] = "Ferrari"
      manufacturers[9] = "Ford"
      carsSmall = new ArrayList<Car>()

      populateRandomCars(carsSmall, 9)
   }

   private void populateRandomCars(List<Car> list, int size) {
      for(int i = 0 ; i < size ; i++)
         list.add(new Car(getRandomPrice(), getRandomYear(), getRandomManufacturer(), getRandomColor()))
   }

   private int getRandomYear() {
      return (int) (Math.random() * 50 + 1960)
   }

   private String getRandomColor() {
      return colors[(int) (Math.random() * 10)]
   }

   private String getRandomManufacturer() {
      return manufacturers[(int) (Math.random() * 10)]
   }

   private long getRandomPrice() {
      return (long)Math.floor( (Math.random() * 100))*300+10000
   }


   public void onCellEdit(CellEditEvent event) {
      Object oldValue = event.getOldValue()
      Object newValue = event.getNewValue()

      if(newValue != null && !newValue.equals(oldValue)) {
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "AJAX: Cell Changed", "Old: " + oldValue + ", New:" + newValue)
         FacesContext.getCurrentInstance().addMessage(null, msg)
      }
   }
}