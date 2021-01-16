package ru.skillbox.catfarm;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.LifecycleSupported;
import ru.skillbox.catfarm.model.CatColor;

@Component
public class Cat extends AbstractCat {

        private static int catCounter = 0;
        private static final double MIN_WEIGHT = 1000.0;
        private static final double MAX_WEIGHT = 9000.0;
        private static final short EYE_AMOUNT = 2;


        private double originWeight;
        private double weight;

        private double minWeight;
        private double maxWeight;

        private double foodCounter;

        private boolean isDead;
        private boolean isExploded;
        private CatColor color;

        public Cat()
        {
            System.out.println("Cat created");
            weight = 1500.0 + 3000.0 * Math.random();
            originWeight = weight;
            minWeight = MIN_WEIGHT;
            maxWeight = MAX_WEIGHT;
            catCounter++;
        }

        public Cat(double weight) {
            this.weight = weight;
            originWeight = weight;
            minWeight = MIN_WEIGHT;
            maxWeight = MAX_WEIGHT;
            catCounter++;
        }

        @LifecycleSupported
        public void meow() {
            if (!this.isDead()) {
                weight = weight - 1;
                System.out.println("Meow ^_^");
            } else {
                setDead();
                System.out.println("Dead cats don't meow...");
            }
        }

        @LifecycleSupported
        private void setDead() {
            if (!this.isDead) {      // cat isn't set as dead yet
                this.isDead = true;
                catCounter--;
            }
        }

        private void setExploded() {
            if (!this.isExploded) {      // cat isn't set as expoded yet
                this.isExploded = true;
                catCounter--;
            }
        }

        @LifecycleSupported
        public void feed(double amount)
        {
            if (!this.isDead() && !this.isExploded()) {
                weight = weight + amount;
                foodCounter += amount;
            } else if (this.isExploded()) {
                setExploded();
            } else if (this.isDead()){
                System.out.println("Dead cats don't eat...");
            }
        }

        public void drink(double amount)
        {
            if (!this.isDead() && !this.isExploded()) {
                weight = weight + amount;
                foodCounter += amount;
            } else if (this.isExploded()) {
                setExploded();
            } else if (this.isDead()){
                System.out.println("Dead cats don't drink...");
            }
        }


        public String getStatus2()
        {
            if(isDead()) {
                return "Dead";
            }
            else if(isExploded()) {
                return "Exploded";
            }
            else if(isSleeping()) {
                return "Sleeping";
            }
            else {
                return "Playing";
            }
        }
        /* ### Following methods have been added in scope of tasks ### */


        @Override
        protected Object clone() throws CloneNotSupportedException {
            Cat clone = new Cat();
            clone.color = this.color;
            clone.weight = this.weight;
            clone.weight = this.originWeight;
            return clone;
        }

        public Double getFoodAmount() {
            return foodCounter;
        }

        public void pee(double seconds) {
            if (this.isDead()) {
                System.out.println("Dead cats are unable to pee-pee...");
                return;
            }
            weight-=seconds;
            System.out.println("ru.skillbox.catfarm.Cat is peeing...");
        }

        public boolean isSleeping() {
            return weight > originWeight;
        }

        public boolean isExploded() {
            return weight > maxWeight;
        }

        public boolean isDead() {
            return weight < minWeight;
        }

        public CatColor getColor() {
            return color;
        }

        public void setColor(CatColor color) {
            this.color = color;
        }
    }
