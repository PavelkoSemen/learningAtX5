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

    public void clearBox() {
        fruitList.clear();
    }

    public void toLeftBox(Box<T> fruitBox) {
        if (!(fruitBox == null)) {
            addBox( fruitBox.fruitList, this.fruitList);
            fruitBox.clearBox();
        }
    }

    public void toRightBox(Box<T> fruitBox) {
        if (!(fruitBox == null)) {
            addBox(this.fruitList, fruitBox.fruitList);
            this.clearBox();
        }
    }

    //Если не использовать свою коллекцию, можно обойтись методом addAll()
    private void addBox(MyArrayList<T> fromList, MyArrayList<T> toList) {
        for (int i = 0; i < fromList.size(); i++) {
            toList.add(fromList.get(i));
        }
    }

    private float getWeight(T fruit, int countFruit) {
        return fruit.getWeight() * countFruit;
    }
}
