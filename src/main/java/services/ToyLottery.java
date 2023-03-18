package services;

import models.Toy;

import java.util.ArrayList;
import java.util.List;

public class ToyLottery {

        private List<Toy> toysList;

        public ToyLottery() {

            this.toysList = new ArrayList<Toy>();
        }

        public List<Toy> getToysList() {

            return toysList;
        }

        public void setToysList(List<Toy> toysList) {

            this.toysList = toysList;
        }


}
