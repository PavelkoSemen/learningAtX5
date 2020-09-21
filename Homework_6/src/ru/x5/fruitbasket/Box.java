package ru.x5.fruitbasket;

import ru.x5.list.MyArrayList;

public class Box<T extends Fruit> {

    private final MyArrayList<T> fruitList;

    public Box() {
        fruitList = new MyArrayList<>();
    }

    public void add(T fruit) {
        fruitList.add(fruit);
    }

    public float getWeight() {

        if (fruitList.isEmpty()) {
            return 0;
        }
        return getWeight(fruitList.get(0), fruitList.size());
    }

    public boolean compare(Box anyBox) {
        if (anyBox == null) {
            return false;
        }
        return this.getWeight() == anyBox.getWeight();
    }

    public void addBox(Box<T> fruitBox) {
        if (!(fruitBox == null && fruitBox.fruitList.isEmpty())) {
            addBox(fruitBox.fruitList);
            fruitBox.clearBox();
        }
    }

    public void clearBox() {
        fruitList.clear();
    }

    private void addBox(MyArrayList<T> fruitList) {
        for (int i = 0; i < fruitList.size(); i++) {
            this.add(fruitList.get(i));
        }
    }

    private float getWeight(T fruit, int countFruit) {
        return fruit.getWeight() * countFruit;
    }
}
