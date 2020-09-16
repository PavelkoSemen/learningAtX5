package ru.x5.computer.graphicscard;

public abstract class GraphicsCard {
    protected int memoryCount;
    protected String typeMemory;
    protected String manufacturer;
    protected StrategyCooling cooling;

    public GraphicsCard(int memoryCount, String typeMemory, String manufacturer) {
        this.memoryCount = memoryCount;
        this.typeMemory = typeMemory;
        this.manufacturer = manufacturer;
    }

    public abstract String cardInfo();

    public String baseCardInfo() {
        return this.manufacturer + ", количество памяти " +
                this.memoryCount + ", тип памяти " +
                this.typeMemory + ", охлаждение " +
                this.typeCooling();
    }

    public String typeCooling() {
        return cooling.installCooling();
    }

    public void setCooling(StrategyCooling cooling) {
        this.cooling = cooling;
    }
}
